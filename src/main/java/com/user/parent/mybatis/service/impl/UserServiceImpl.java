package com.user.parent.mybatis.service.impl;

import com.user.parent.mybatis.bean.Member;
import com.user.parent.mybatis.bean.TokenInfo;
import com.user.parent.mybatis.dao.UserMapper;
import com.user.parent.mybatis.response.MemberResponse;
import com.user.parent.mybatis.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by lsq.
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public Member findById(Long id) {
        return userMapper.findById(id);
    }

    @Override
    public Member findByLoginName(String loginName) {
        return userMapper.findByLoginName(loginName);
    }

    @Override
    public Integer update(Member member) {
        return userMapper.update(member);
    }

    @Override
    public MemberResponse getShopByCode(String code) {
        return userMapper.getShopByCode(code);
    }

    @Override
    public void getShop(MemberResponse memberResponse, String code)      {
        //拿出来门店和公司等信息
        MemberResponse m = userMapper.getShopByCode("\""+code+"\"");
        memberResponse.setAddress(m.getAddress());
        memberResponse.setBrandName(m.getBrandName());
        memberResponse.setCompanyName(m.getCompanyName());
        memberResponse.setShopName(m.getShopName());
        memberResponse.setPhoneNum(m.getPhoneNum());
    }

    @Override
    public String getToken (String loginName){
        TokenInfo info = userMapper.getToken(loginName);
        if (info == null ||
                (System.currentTimeMillis() - info.getCreateTime().getTime())>1000 * 60 * 20){
            return "";
        }
        return info.getToken();
    }
}
