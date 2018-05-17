package com.hzg.mybatisdemo.test;

import com.hzg.mybatisdemo.domain.Item;
import com.hzg.mybatisdemo.domain.Order;
import com.hzg.mybatisdemo.domain.User;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestOrderCRUD {

    private SqlSession sqlSession;

    @Before
    public void init() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }
    @Test
    public void testInsert() throws Exception {
        User user = new User();
        user.setId(2);
        Order order = new Order();
        order.setOrderNo("No005");
        order.setUser(user);
        sqlSession.insert("orders.insert", order);
    }

    @Test
    public void selectOne() throws Exception {

        Order order = (Order) sqlSession.selectOne("orders.selectOne", 1);
        System.out.println(order.getOrderNo() + order.getUser().getName());
        for (Item item : order.getItems()) {
            System.out.println(item.getId() + ":" + item.getItemName());
        }
    }

    @Test
    public void selectAll() throws Exception {

        List<Order> orders = sqlSession.selectList("orders.selectAll");
        for (Order order : orders) {
            System.out.println(order.getUser().getName());
        }

    }
    @After
    public void after(){
        sqlSession.commit();
        sqlSession.close();
    }
}
