package com.user.parent.mybatis.service;

import com.user.parent.mybatis.bean.Member;
import com.user.parent.mybatis.response.MemberResponse;

/**
 * Created by dengb.
 */
public interface UserService {

    Member findById(Long id);
    Member findByLoginName(String loginName);

    Integer update(Member member);

    MemberResponse getShopByCode(String code);

    void getShop(MemberResponse memberResponse, String code);

    String getToken (String loginName);
}
