package com.yoyling.mybatis.factory;

import com.yoyling.mybatis.sqlsession.SqlSession;

public interface SqlSessionFactory {

    SqlSession openSession();
}
