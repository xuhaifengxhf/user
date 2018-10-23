package com.user.parent.mybatis.dao;

import com.user.parent.mybatis.bean.Member;
import com.user.parent.mybatis.bean.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * Created by lsq.
 */
@Mapper
@Component
public interface RoleMapper {
    Role findById(@Param(value = "id") Long id);
}
