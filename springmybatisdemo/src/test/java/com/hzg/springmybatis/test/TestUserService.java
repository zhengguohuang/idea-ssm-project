package com.hzg.springmybatis.test;

import com.hzg.springmybatis.domain.User;
import com.hzg.springmybatis.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class TestUserService {
    @Test
    public void testUserService() throws SQLException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        UserService us = (UserService) ac.getBean("userService");
        User user = us.selectOne(1);
        System.out.println(user.getName());
    }
}
