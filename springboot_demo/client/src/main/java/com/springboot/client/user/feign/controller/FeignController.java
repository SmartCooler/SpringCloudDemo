package com.springboot.client.user.feign.controller;

import com.springboot.client.user.feign.service.FeignService;
import com.springboot.client.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user3")
public class FeignController {

    @Autowired
    private FeignService feignService;

    @RequestMapping("/getUserByFeignWeb")
    public String getUserByFeignWeb() throws Exception{
        String res = feignService.queryUserAll();
        System.out.println(res);
        return res;
    }

}
