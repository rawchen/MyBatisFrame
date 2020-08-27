package com.yoyling.mybatis.mapper;

import com.yoyling.mybatis.entity.User;

import java.util.List;

public interface UserMapper {

    User selectByPrimaryKey(long userId);

    List<User> selectAll();
}
