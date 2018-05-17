package com.hzg.springmybatis.service.impl;

import com.hzg.springmybatis.domain.Item;
import com.hzg.springmybatis.service.ItemService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ItemServiceTest {
    @Test
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        ItemService is = (ItemService) ac.getBean("itemService");
        Item item = is.selectOne(1);
        System.out.println(item.getItemName());
    }
    @Test
    public void selectOne() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        ItemService is = (ItemService) ac.getBean("itemService");
        Item item = is.selectOne(2);
        System.out.println(item.getItemName() +"\t"+ item.getOrder().getOrderNo() +"\t"+ item.getOrder().getUser().getName());
    }
}