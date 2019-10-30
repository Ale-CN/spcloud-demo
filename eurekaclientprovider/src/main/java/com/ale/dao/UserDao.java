package com.ale.dao;

import com.ale.bean.User;

import java.util.Collection;

public interface UserDao {
    User get(Long id);

    Collection<User> findAll();

    void saveOrUpdate(User user);

    void delete(Long id);

}
