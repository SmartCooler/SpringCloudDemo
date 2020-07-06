package com.springboot.client.user.controller;

import com.springboot.client.user.pojo.User;
import com.springboot.client.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/addUser")
    public String addUser (){
        User user = new User();
        user.setName("刘德华");
        user.setPassword("0000002");
        user.setSex(1);
        user.setBirthday(new Date());
        int res = userService.insert(user);
        System.out.println("查询结果是：" + res);
        return res + "";
    }

    @RequestMapping("/selectAll")
    public String selectAll(){
        List<User> list = userService.selectAll();
        list.stream().forEach(System.out::println);
        return list.toString();
    }

    @RequestMapping("/selectById/{id}")
    public String selectById(@PathVariable int id){
        User user = userService.selectById(id);
        return user.toString();
    }

    @RequestMapping("/delete")
    public String delete(){
        int res = userService.delete(107);
        return res + "";
    }

    @RequestMapping("/update")
    public String update(){
        int res = userService.update("Andy",23,2,107);
        return res + "";
    }

}
