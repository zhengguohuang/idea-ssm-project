package com.hzg.springmybatis.service.impl;

import com.hzg.springmybatis.dao.BaseDao;
import com.hzg.springmybatis.domain.Item;
import com.hzg.springmybatis.domain.User;
import com.hzg.springmybatis.service.ItemService;
import com.hzg.springmybatis.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("itemService")
public class ItemServiceImpl extends BaseServiceImpl<Item> implements ItemService{
    // 重写该方法注入指定dao对象
    @Override
    @Resource(name = "itemDao")
    public void setDao(BaseDao<Item> dao) {
        super.setDao(dao);
    }
}
