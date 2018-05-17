package com.hzg.springmybatis.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class TestDataSource {
    @Test
    public void testConn() throws SQLException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        DataSource ds = (DataSource) ac.getBean("dataSource");
        System.out.println(ds.getConnection());
    }
}
