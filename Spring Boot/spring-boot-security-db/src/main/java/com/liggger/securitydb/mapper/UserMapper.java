package com.liggger.securitydb.mapper;

import com.liggger.securitydb.bean.Role;
import com.liggger.securitydb.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    User loadUserByUsername(String username);

    List<Role> getUserRolesById(Integer id);
}
