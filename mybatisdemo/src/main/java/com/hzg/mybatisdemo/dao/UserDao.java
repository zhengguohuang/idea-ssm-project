package com.hzg.mybatisdemo.dao;

import com.hzg.mybatisdemo.domain.User;
import com.hzg.mybatisdemo.util.Util;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDao {
    /**
     * 插入操作
     * @param user
     */
    public void insert(final User user) {
        DaoTemplate.execute(new MybatisCallback() {
            public Object doInMybatis(SqlSession sqlSession) {
                sqlSession.insert("users.insert", user);
                return null;
            }
        });
    }

    /**
     * 更新操作
     * @param user
     */
    public void update(final User user) {
        DaoTemplate.execute(new MybatisCallback() {
            public Object doInMybatis(SqlSession sqlSession) {
                sqlSession.insert("users.update", user);
                return null;
            }
        });
    }

    /**
     * findById
     * @param id
     */
    public User selectOne(final Integer id) {
        return (User) DaoTemplate.execute(new MybatisCallback() {
            public Object doInMybatis(SqlSession sqlSession) {
                return sqlSession.selectOne("users.selectOne", id);
            }
        });
    }

    /**
     * findAll
     * @param
     */
    public List<User> selectAll() {
        return (List<User>) DaoTemplate.execute(new MybatisCallback() {
            public Object doInMybatis(SqlSession sqlSession) {
                return sqlSession.selectList("users.selectAll");
            }
        });
    }
}
