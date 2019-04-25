package com.mirkelor.dao;

import com.mirkelor.entity.User;

public interface UserDao {

    User findByUserName(String userName);

    void save(User user);
}
