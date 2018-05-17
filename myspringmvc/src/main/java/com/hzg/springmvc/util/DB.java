package com.hzg.springmvc.util;

import com.hzg.springmvc.domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DB {
    public static Map<Integer, User> tables = new HashMap<Integer, User>();

    static {
        for (int i = 1; i <= 30; i++) {
            User u = new User();
            u.setId(i);
            u.setName("tom" + i);
            u.setAge(i % 20);
            tables.put(i, u);
        }
    }

    /**
     * 查询全部用户
     * @return
     */
    public static List<User> findAll(){
        return new ArrayList<User>(tables.values());
    }

    /**
     * 根据id删除用户
     * @param uid
     */
    public static void delete(Integer uid){
        tables.remove(uid);
    }

    /**
     * 查询一个用户
     */
    public static User findOne(Integer uid){
        return tables.get(uid);
    }

    /**
     * 更新
     */
    public static void update(User user){
        tables.put(user.getId(), user);
    }

    /**
     * 删除全部
     */
    public static void deleteAll(){
        tables.clear();
    }
}
