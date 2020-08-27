package com.yoyling.mybatis.sqlsession;

import com.yoyling.mybatis.bind.MapperProxy;
import com.yoyling.mybatis.confiuration.Configuration;
import com.yoyling.mybatis.confiuration.MappedStatement;
import com.yoyling.mybatis.executor.Executor;
import com.yoyling.mybatis.executor.SimpleExecutor;

import java.lang.reflect.Proxy;
import java.util.List;

public class DefaultSqlSession implements  SqlSession {

    private final Configuration configuration;

    private Executor executor;

    public DefaultSqlSession(Configuration configuration) {
        super();
        this.configuration = configuration;
        executor = new SimpleExecutor(configuration);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        List<T> selectList = this.selectList(statement,parameter);
        if(selectList == null || selectList.size() == 0){
            return null;
        }
        if(selectList.size() == 1){
            return (T) selectList.get(0);
        }else{
            throw new RuntimeException("too many result");
        }
    }

    @Override
    public <T> List<T> selectList(String statement, Object parameter) {
        MappedStatement ms = configuration.getMappedStatement().get(statement);
        return executor.query(ms,parameter);
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        MapperProxy mp = new MapperProxy(this);
        //给我一个接口，还你一个实现类
        return (T)Proxy.newProxyInstance(type.getClassLoader(),new Class[]{type},mp);
    }
}
