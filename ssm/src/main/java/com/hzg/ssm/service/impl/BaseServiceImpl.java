package com.hzg.ssm.service.impl;



import com.hzg.ssm.dao.BaseDao;
import com.hzg.ssm.domain.User;
import com.hzg.ssm.service.BaseService;

import java.util.List;

public abstract class BaseServiceImpl<T> implements BaseService<T> {

    private BaseDao<T> dao;

    public void setDao(BaseDao<T> dao) {
        this.dao = dao;
    }

    public void insert(T t) {
        dao.insert(t);
    }

    public void update(T t) {
        dao.update(t);
    }

    public void delete(Integer id) {
        dao.delete(id);
        //throw new RuntimeException("出错了！");
    }

    public T selectOne(Integer id) {
        return dao.selectOne(id);
    }

    public List<T> selectAll() {
        return dao.selectAll();
    }

    /**
     * 分页查询
     */
    public  List<T> selectPage(int offset, int len){
        return  dao.selectPage(offset, len);
    }

    public int selectCount() {
        return dao.selectCount();
    }
}
