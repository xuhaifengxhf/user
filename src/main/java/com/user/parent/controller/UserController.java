package com.user.parent.controller;

import com.alibaba.fastjson.JSONObject;
import com.user.parent.alisdk.ANY_CALL;
import com.user.parent.mybatis.bean.Member;
import com.user.parent.mybatis.response.MemberResponse;
import com.user.parent.mybatis.service.UserService;
import com.user.parent.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Time;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by LSQ.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * 根据unionid  拿出session中的登录信息  --不用
     */
    @RequestMapping(value = "/getLoginSessionByUnion", method = RequestMethod.GET)
    public @ResponseBody
    Object getLoginSessionByUnion(HttpServletRequest request) {
        String openid = request.getParameter("openid");
        //根据  unionid去拿信息
        JSONObject result = new JSONObject();
        result.put("status", "0");
        result.put("message", "成功");
        JSONObject data = new JSONObject();
        HttpSession session = request.getSession();
        MemberResponse member = (MemberResponse) session.getAttribute(openid);
        if (member != null) {
            data.put("user", member);
        } else {
            data.put("user", null);
        }
        result.put("data",data);
        return result;
    }

    /**
     * 门店登录接口
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody
    Object login(HttpServletRequest request, HttpServletResponse response,@RequestBody Member params)throws Exception {
        //校验登录名和密码
        //如果  登录失败,更新登录失败次数
        //检查用户是否锁定lock
        //检查用户帐号是否已经 激活  activated?
        //  检查用户帐号是否已经删除  deleted ?
        //密码加密规则
        //登录成功 , 返回 success
        if (params.getLoginName() == null || params.getLoginName() == "") {
            return EnumUtil.errorToJson(ErrorCode.api_account_input_login_name);
        }
        Member memberdb = userService.findByLoginName(params.getLoginName());
        MemberResponse memberResponse = null;
        if (memberdb == null) {
            return EnumUtil.errorToJson(ErrorCode.api_account_LoginNamealnoexists);
        } else {
            if (!memberdb.getEnabled()) {
                return EnumUtil.errorToJson(ErrorCode.api_account_input_cannot_login);
            }
//            if (!memberdb.getRoleIds().contains("15")) {
//                return EnumUtil.errorToJson(ErrorCode.api_account_input_cannot_login);
//            }
            memberResponse = new MemberResponse(memberdb);
            String password = params.getPasswdHash();
            System.out.println("password = [" + passwordEncoder.encode(password) + "]");
            if (!passwordEncoder.matches(password, memberdb.getPasswdHash())) {
                //TODO  登录失败更新状态
//                Integer failCount = memberdb.getFailedLogins();
//                if (failCount == null) failCount = 0;
//                memberdb.setFailedLogins(++failCount);
//                if (failCount >= 3) {
//                    memberdb.setEnabled(false);
//                }
//                memberdb.setUpdateTime(new Date());
//                userService.update(memberdb);
//                Map map = new HashMap();
//                map.put("enabled",false);
//                map.put("updateTime",new Date());
//                map.put("failedLogins", (memberdb.getFailedLogins())+1);
//                map.put("userId",memberdb.getId());
//                HttpClientUtil.sendPost("",map,"UTF-8");
                return EnumUtil.errorToJson(ErrorCode.api_account_password_error);
            } else {
//                memberdb.setUpdateTime(new Date());
//                memberdb.setFailedLogins(0);
//                userService.update(memberdb);
                //TODO
                Map map = new HashMap();
                map.put("enabled",true);
                map.put("updateTime",new Date());
                map.put("failedLogins", 0);
                map.put("userId",memberdb.getId());
//                HttpClientUtil.sendPost("",map,"UTF-8");
                //根据unionid更新关联信息
//                String unionid =  RedisManager.get((params.getOpenid() == null ?"":params.getOpenid())+1);
                if (!StringUtils.isEmpty(params.getUnionid())) {
                    map = new HashMap();
                    map.put("unionid",params.getUnionid());
                    map.put("userId", memberdb.getId());
//                    HttpClientUtil.sendPost("", map, "UTF-8");
                    ANY_CALL.crateWxUser(params.getUnionid(), String.valueOf(params.getId()),
                            params.getLoginName(),params.getPasswdHash(),userService.getToken(params.getLoginName()));
                }
                userService.getShop(memberResponse, memberdb.getDepartmentCode());


            }
        }
        memberResponse.setTime(System.currentTimeMillis());
        JSONObject result = new JSONObject();
        result.put("status", "0");
        result.put("message", "成功");
        JSONObject data = new JSONObject();
        data.put("user", memberResponse);
        result.put("data", data);
//        RedisManager.set(params.getOpenid(), JsonUtil.toJSON(memberResponse),60*60*24*7);
        return result;
    }

    /**
     * 改密
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/changePwd", method = RequestMethod.POST)
    public @ResponseBody
    Object changePwd(HttpServletRequest request, HttpServletResponse response,@RequestBody Member params) {
        if (StringUtils.isEmpty(params.getfNewPwd()) ||
                StringUtils.isEmpty(params.getPasswdHash())) {
            return EnumUtil.errorToJson(ErrorCode.PARAM_ERROR);
        }
        if (params.getId() == null || params.getId() == 0) {
            return EnumUtil.errorToJson(ErrorCode.PARAM_ERROR);
        }

        Member memberdb = userService.findById(params.getId());

        if (memberdb == null) {
            return EnumUtil.errorToJson(ErrorCode.api_account_LoginNamealnoexists);
        } else {
            System.out.println("password = [" + passwordEncoder.encode(params.getPasswdHash()) + "]");
            if (!passwordEncoder.matches(params.getPasswdHash(), memberdb.getPasswdHash())) {
                return EnumUtil.errorToJson(ErrorCode.api_account_old_password_error);
            } else {
                ANY_CALL.chagePwd(params.getLoginName(),params.getPasswdHash(),params.getfNewPwd(),
                        userService.getToken(params.getLoginName()));
            }
        }
        MemberResponse  memberResponse = new MemberResponse(memberdb);
        userService.getShop(memberResponse, memberdb.getDepartmentCode());
        JSONObject result = new JSONObject();
        result.put("status", "0");
        result.put("message", "成功");
        JSONObject data = new JSONObject();
        data.put("user", memberResponse);
        result.put("data", data);
//        RedisManager.set(params.getOpenid(), JsonUtil.toJSON(memberResponse),60*60*24*7);
        return result;
    }

    /**
     * 退出登录
     */
    @RequestMapping(value = "/exitLogin", method = RequestMethod.GET)
    public @ResponseBody
    Object exitLogin(HttpServletRequest request) {
        String openid = request.getParameter("openid");
//       RedisManager.delete(openid);
        //根据  unionid去拿信息
        JSONObject result = new JSONObject();
        result.put("status", "0");
        result.put("message", "成功");
        return result;
    }



}
