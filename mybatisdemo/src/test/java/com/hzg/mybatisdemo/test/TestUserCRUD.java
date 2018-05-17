package com.hzg.mybatisdemo.test;

import com.hzg.mybatisdemo.domain.Order;
import com.hzg.mybatisdemo.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestUserCRUD {

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
        user.setName("hzg");
        user.setAge(22);
        sqlSession.insert("users.insert", user);
    }

    @Test
    public void testUpdate() throws Exception {
        User user = new User();
        user.setName("hzg3");
        user.setAge(22);
        user.setId(6);
        sqlSession.update("users.update", user);
    }

    @Test
    public void selectOne() throws Exception {
        User user = new User();
        user.setId(1);
        User u = (User) sqlSession.selectOne("users.selectOne", user);
        System.out.println(u.getName());
        for (Order order : u.getOrders()) {
            System.out.println(order.getId() + ":" + order.getOrderNo());
        }
    }

    @Test
    public void selectAll() throws Exception {
        List<User> users = sqlSession.selectList("users.selectAll");
        for (User user : users) {
            System.out.println(user.getName());
            for (Order order : user.getOrders()) {
                System.out.println(order.getId() + ":" + order.getOrderNo());
            }
        }
    }

    @After
    public void after(){
        sqlSession.commit();
        sqlSession.close();
    }
}
