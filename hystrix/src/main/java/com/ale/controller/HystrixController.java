package com.ale.controller;

import com.ale.bean.User;
import com.ale.feign.FeignConsumerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/hystrix")
public class HystrixController {

    @Autowired
    FeignConsumerClient feignConsumerClient;

    @GetMapping("/index")
    public String index() {
        return feignConsumerClient.index();
    }

    @GetMapping("/findAll")
    public Collection<User> findAll() {
        return feignConsumerClient.findAll();
    }
}
