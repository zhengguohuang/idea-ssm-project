package com.hzg.springdemo.service;


import com.hzg.springdemo.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

// spring扫描包的时候会扫描注解
@Service("ws")//不写默认为welcomeService

public class WelcomeService {
    private String message = "hello";
    private UserDao dao;

    // 需添加set方法便于spring注入
    @Resource(name="userDao")//resource用于注入
    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }

    public void sayHello() {
        System.out.println(message);
        dao.insert();
    }
}


