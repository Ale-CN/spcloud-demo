package com.ale.feign.impl;

import com.ale.bean.User;
import com.ale.feign.FeignConsumerClient;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class FeignConsumerError implements FeignConsumerClient {
    @Override
    public Collection<User> findAll() {
        return null;
    }

    @Override
    public String index() {
        return "服务器维护中...";
    }
}
