package com.hzg.mybatisdemo.dao;

import com.hzg.mybatisdemo.util.Util;
import org.apache.ibatis.session.SqlSession;

public class DaoTemplate {
    /**
     * 执行
     */
    public static Object execute(MybatisCallback callback){
        SqlSession sqlSession = null;
        try {
            sqlSession = Util.openSession();
            //s.update("users.update", user);
            Object ret = callback.doInMybatis(sqlSession);
            sqlSession.commit();
            return ret;
        } catch (Exception e){
            e.printStackTrace();
            Util.rollbackTx(sqlSession);
        } finally {
            Util.clossSession(sqlSession);
        }
        return null;
    }
}
