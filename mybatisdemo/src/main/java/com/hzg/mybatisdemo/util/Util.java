package com.hzg.mybatisdemo.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Util {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 开启会话
     * @return
     */
    public static SqlSession openSession(){
        return sqlSessionFactory.openSession();
    }

    /**
     * 关闭会话
     * @return
     */
    public static void clossSession(SqlSession sqlSession){
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    /**
     * 回滚事务
     * @return
     */
    public static void rollbackTx(SqlSession sqlSession){
        if (sqlSession != null) {
            sqlSession.rollback();
        }
    }
}
