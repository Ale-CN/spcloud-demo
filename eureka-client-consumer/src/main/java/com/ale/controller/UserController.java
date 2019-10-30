package com.ale.controller;

import com.ale.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/get/{id}")
    public User get(@PathVariable("id") long id) {
        return restTemplate.getForEntity("http://localhost:9010/user/get/{id}", User.class, id).getBody();
    }

    @GetMapping("/get2/{id}")
    public User get2(@PathVariable("id") long id) {
        return restTemplate.getForObject("http://localhost:9010/user/get/{id}", User.class, id);
    }

    @GetMapping("/findAll")
    public Collection<User> findAll() {
        return restTemplate.getForObject("http://localhost:9010/user/findAll", Collection.class);
    }

    @GetMapping("/findAll2")
    public Collection<User> findAll2() {
        return restTemplate.getForEntity("http://localhost:9010/user/findAll", Collection.class).getBody();
    }

    @PostMapping("/save")
    public void save(@RequestBody User user) {
        restTemplate.postForEntity("http://localhost:9010/user/save", user, null).getBody();
    }

    @PostMapping("/save2")
    public void save2(@RequestBody User user) {
        restTemplate.postForObject("http://localhost:9010/user/save", user, null);
    }

    @PutMapping("/update")
    public void update(@RequestBody User user) {
        restTemplate.put("http://localhost:9010/user/update", user);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") long id) {
        restTemplate.delete("http://localhost:9010/user//delete/{id}", id);
    }

}
