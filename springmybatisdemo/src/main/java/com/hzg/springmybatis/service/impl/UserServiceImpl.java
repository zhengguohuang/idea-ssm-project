package com.hzg.springmybatis.service.impl;

import com.hzg.springmybatis.dao.BaseDao;
import com.hzg.springmybatis.domain.Item;
import com.hzg.springmybatis.domain.Order;
import com.hzg.springmybatis.domain.User;
import com.hzg.springmybatis.service.ItemService;
import com.hzg.springmybatis.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{

    @Resource(name = "itemDao")
    private BaseDao<Item> itemDao;

    // 重写该方法注入指定dao对象
    @Override
    @Resource(name = "userDao")
    public void setDao(BaseDao<User> dao) {
        super.setDao(dao);
    }

    /**
     * 长事务测试
     */
    public void longTx() {
        // 插入item
        Item i = new Item();
        i.setItemName("ttt");
        Order o = new Order();
        o.setId(2);
        i.setOrder(o);
        itemDao.insert(i);

        // 删除抛出异常
        this.delete(1);
    }
}
