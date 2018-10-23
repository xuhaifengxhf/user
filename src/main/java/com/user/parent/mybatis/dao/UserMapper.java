package com.user.parent.mybatis.dao;

import com.user.parent.mybatis.bean.Member;
import com.user.parent.mybatis.bean.TokenInfo;
import com.user.parent.mybatis.response.MemberResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * Created by lsq.
 */
@Mapper
@Component
public interface UserMapper {
    Member findById(@Param(value = "id")Long id);

    Member findByLoginName(@Param(value = "loginName") String loginName);

    Integer update(Member member);

    MemberResponse getShopByCode(@Param(value = "code")String code);

    /**
     * 根据登录名拿tokens
     *
     * @param loginName
     * @return
     */
    TokenInfo getToken(@Param(value = "loginName") String loginName);
}
