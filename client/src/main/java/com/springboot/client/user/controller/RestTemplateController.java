package com.springboot.client.user.controller;

import com.springboot.client.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user4")
public class RestTemplateController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value="/getUserByRestTemplateWeb/{flag}",method = RequestMethod.GET)
    public String getUserByRestTemplateWeb(@PathVariable String flag) throws Exception{
        User res = new User();
        try{
            if(("1").equals(flag)){
                //1、传递map参数列表
                Map<String,String> map = new HashMap<>();
                map.put("id","100");
                res = restTemplate.getForObject("http://localhost:8082/user6/queryUserById/",User.class,map);
            }else if(("2").equals(flag)){
                //2、直接传递参数
                res = restTemplate.getForObject("http://localhost:8082/user6/queryUserById/{1}",User.class,100);
            }else if(("3").equals(flag)){
                //3、无参数
                res = restTemplate.getForObject("http://localhost:8082/user6/queryUserById",User.class);
            }else if(("4").equals(flag)){
                res = restTemplate.postForObject("http://localhost:8082/user6/queryUserById/{1}",100,User.class);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(res);
        return res.toString();
    }
}
