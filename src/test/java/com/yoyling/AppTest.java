package com.yoyling;

import com.yoyling.mybatis.entity.User;
import com.yoyling.mybatis.factory.DefaultSqlSessionFactory;
import com.yoyling.mybatis.factory.SqlSessionFactory;
import com.yoyling.mybatis.mapper.UserMapper;
import com.yoyling.mybatis.sqlsession.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void test(){
        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.selectByPrimaryKey(41L);
        System.out.println(user.getUsername());

        List<User> lists = mapper.selectAll();
        for (User u : lists) {
            System.out.println(u);
        }
    }
}
