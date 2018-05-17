package com.hzg.springmybatis.service.impl;

import com.hzg.springmybatis.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {
    @Test
    public void longTx(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        UserService userService = (UserService) ac.getBean("userService");
        userService.longTx();
    }
}