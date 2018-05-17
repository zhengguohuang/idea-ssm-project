package com.hzg.springdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    public void insert(){
        System.out.println("insert over");
    }
}