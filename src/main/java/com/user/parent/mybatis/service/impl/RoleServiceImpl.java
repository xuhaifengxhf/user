package com.user.parent.mybatis.service.impl;

import com.user.parent.mybatis.bean.Member;
import com.user.parent.mybatis.bean.Role;
import com.user.parent.mybatis.dao.RoleMapper;
import com.user.parent.mybatis.dao.UserMapper;
import com.user.parent.mybatis.service.RoleService;
import com.user.parent.mybatis.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by lsq.
 */
@Service
public class RoleServiceImpl implements RoleService {
    private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role findById(Long id) {
        return roleMapper.findById(id);
    }
}