package com.yoyling.mybatis;

import com.yoyling.mybatis.entity.User;
import com.yoyling.mybatis.factory.DefaultSqlSessionFactory;
import com.yoyling.mybatis.factory.SqlSessionFactory;
import com.yoyling.mybatis.mapper.UserMapper;
import com.yoyling.mybatis.sqlsession.SqlSession;

public class TestDemo {

    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.selectByPrimaryKey(1L);

        System.out.println(user.toString());
    }
}
