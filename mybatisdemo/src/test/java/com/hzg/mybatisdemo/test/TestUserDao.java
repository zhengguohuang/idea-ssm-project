package com.hzg.mybatisdemo.test;

import com.hzg.mybatisdemo.dao.UserDao;
import com.hzg.mybatisdemo.domain.User;
import org.junit.Test;

import java.util.List;

public class TestUserDao {

    /**
     * selectOne
     */
    @Test
    public void selectOne(){
        UserDao dao = new UserDao();
        User user = dao.selectOne(2);
        System.out.println(user.getName());
    }

    /**
     * selectAll
     */
    @Test
    public void selectAll(){
        UserDao dao = new UserDao();
        List<User> users = dao.selectAll();
        for (User user : users) {
            System.out.println(user.getName());
        }
    }
}
