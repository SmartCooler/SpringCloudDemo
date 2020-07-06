package com.springboot.client.user.service.impl;

import com.springboot.client.user.mapper.User2Mapper;
import com.springboot.client.user.pojo.User;
import com.springboot.client.user.service.User2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User2ServiceImpl implements User2Service {

    @Autowired
    private User2Mapper user2Mapper;

    @Override
    public User login(String user_Name, String password) {
        return user2Mapper.login(user_Name, password);
    }

    @Override
    public List<User> queryUserByTableName(String tableName) {
        List<User> userList = user2Mapper.queryUserByTableName(tableName);
        return userList;
    }

    @Override
    public User queryUserById(Integer id) {
        return user2Mapper.queryUserById(id);
    }

    @Override
    public List<User> queryUserAll() {
        List<User> userList = user2Mapper.queryUserAll();
        return userList;
    }

    @Override
    public List<User> queryByName(String name){
        List<User> userList = user2Mapper.queryByName(name);
        return userList;
    }
    @Override
    public List<User> queryByNameOrAge(String name, Integer age){
        List<User> userList = user2Mapper.queryByNameOrAge(name,age);
        return userList;
    }

    @Override
    public List<User> queryByNameOrAge2(String name, Integer age){
        List<User> userList = user2Mapper.queryByNameOrAge2(name,age);
        return userList;
    }

    @Override
    public List<User> queryByIds(List<Integer> ids){
        List<User> userList = user2Mapper.queryByIds(ids);
        return userList;
    }

    @Override
    public int insertUser(User user) {
        return user2Mapper.insertUser(user);
    }

    @Override
    public int updateUser(User user) {
        return user2Mapper.updateUser(user);
    }

    @Override
    public int deleteUserById(Integer id) {
        return user2Mapper.deleteUserById(105);
    }
}
