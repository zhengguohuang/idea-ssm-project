package com.hzg.ssm.service.impl;


import com.hzg.ssm.dao.BaseDao;
import com.hzg.ssm.domain.Item;
import com.hzg.ssm.domain.Order;
import com.hzg.ssm.domain.User;
import com.hzg.ssm.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

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

    public void save(User u) {
        if (u.getId() != null){
            this.update(u);
        }
        else {
            this.insert(u);
        }
    }



}
