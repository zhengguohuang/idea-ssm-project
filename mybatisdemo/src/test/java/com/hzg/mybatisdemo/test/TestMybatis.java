package com.hzg.mybatisdemo.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

public class TestMybatis {

    @Test
    public void testConnection() throws Exception {
        // 指定配置文件路径(类路径)
        String resource = "mybatis-config.xml";
        // 加载文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 构建会话工厂，相当于连接池
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 通过sf打开会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        System.out.println(sqlSession);
    }
}
