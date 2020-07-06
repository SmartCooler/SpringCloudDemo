package com.springboot.client.user.service;

import com.springboot.client.user.pojo.User;

import java.util.List;

public interface UserService {

    //新增
    int insert(User user);

    //根据id删除一个用户
    int delete(Integer id);

    //根据id更改用户信息
    int update(String name, Integer age, Integer sex, Integer id);

    //查询一个用户信息
    User selectById(Integer id);

    //查询所有的用户信息
    List<User> selectAll();

}
