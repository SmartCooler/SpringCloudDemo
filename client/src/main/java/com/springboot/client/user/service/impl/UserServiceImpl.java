package com.springboot.client.user.service.impl;

import com.springboot.client.user.mapper.UserMapper;
import com.springboot.client.user.pojo.User;
import com.springboot.client.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insert(User user){
        return userMapper.insert(user);
    }

    @Override
    public int delete(Integer id){
        return userMapper.delete(id);
    }

    @Override
    public int update(String name,Integer age,Integer sex,Integer id){
        return userMapper.update(name,age,sex,id);
    }

    @Override
    public User selectById(Integer id){
        return userMapper.selectById(id);
    }

    @Override
    public List<User> selectAll(){
        return userMapper.selectAll();
    }


}
