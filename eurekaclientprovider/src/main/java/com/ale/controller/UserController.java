package com.ale.controller;

import com.ale.bean.User;
import com.ale.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserDao userDao;

    @Value("${server.port}")
    private String port;

    @GetMapping("/get/{id}")
    public User get(@PathVariable("id") Long id) {
        return userDao.get(id);
    }

    @GetMapping("/findAll")
    public Collection<User> findAll() {
        return userDao.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        userDao.delete(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody User user) {
        userDao.saveOrUpdate(user);
    }

    @PostMapping("/save")
    public void save(@RequestBody User user) {
        userDao.saveOrUpdate(user);
    }

    @RequestMapping("/index")
    public String index() {
        return "当前端口：" + this.port;
    }
}
