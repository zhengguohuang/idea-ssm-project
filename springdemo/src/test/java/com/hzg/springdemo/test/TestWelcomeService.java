package com.hzg.springdemo.test;

import com.hzg.springdemo.service.WelcomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestWelcomeService {
    @Test
    public void test1(){
        WelcomeService ws = new WelcomeService();
        ws.setMessage("hello world");
        ws.sayHello();
    }
    @Test
    public void test2(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        WelcomeService ws = (WelcomeService)ac.getBean("ws");
        ws.sayHello();
    }
}
