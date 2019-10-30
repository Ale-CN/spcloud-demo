package com.ale.dao.impl;

import com.ale.bean.User;
import com.ale.dao.UserDao;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {

    private static Map<Long, User> userMap = new HashMap<>();

    static {
        userMap.put(1L, new User(1L, "李天一", "lty", "111111"));
        userMap.put(2L, new User(2L, "王小二", "wxe", "222222"));
        userMap.put(3L, new User(3L, "张三", "zs", "333333"));
    }

    @Override
    public User get(Long id) {
        return userMap.get(id);
    }

    @Override
    public Collection<User> findAll() {
        return userMap.values();
    }

    @Override
    public void saveOrUpdate(User user) {
        userMap.put(user.getId(), user);
    }

    @Override
    public void delete(Long id) {
        userMap.remove(id);
    }
}
