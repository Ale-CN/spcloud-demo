package com.ale.feign;

import com.ale.bean.User;
import com.ale.feign.impl.FeignConsumerError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@FeignClient(value = "provider01", fallback = FeignConsumerError.class)
public interface FeignConsumerClient {
    @GetMapping("/user/findAll")
    Collection<User> findAll();

    @GetMapping("/user/index")
    String index();
}
