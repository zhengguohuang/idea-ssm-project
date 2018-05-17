package com.hzg.springmybatis.service;

import com.hzg.springmybatis.domain.User;

public interface UserService extends BaseService<User> {
    public void longTx();
}
