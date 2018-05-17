package com.hzg.ssm.service.impl;


import com.hzg.ssm.dao.BaseDao;
import com.hzg.ssm.domain.Item;
import com.hzg.ssm.service.ItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("itemService")
public class ItemServiceImpl extends BaseServiceImpl<Item> implements ItemService {
    // 重写该方法注入指定dao对象
    @Override
    @Resource(name = "itemDao")
    public void setDao(BaseDao<Item> dao) {
        super.setDao(dao);
    }
}
