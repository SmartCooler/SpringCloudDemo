package com.springboot.client.user.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "client2")
public interface FeignService {

    @RequestMapping("/user6/queryUserAll")
    String queryUserAll();
}
