package com.hzg.ssm.service;


import com.hzg.ssm.domain.User;

public interface UserService extends BaseService<User> {
    public void longTx();

    void save(User u);
}
