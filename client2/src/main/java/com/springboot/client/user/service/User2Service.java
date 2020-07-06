package com.springboot.client.user.service;

import com.springboot.client.user.pojo.User;

import java.util.List;

public interface User2Service {

    public User login(String user_Name, String password);

    public List<User> queryUserByTableName(String tableName);

    public User queryUserById(Integer id);

    public List<User> queryUserAll();

    public List<User> queryByName(String name);

    public List<User> queryByNameOrAge(String name, Integer age);

    public List<User> queryByNameOrAge2(String name, Integer age);

    public List<User> queryByIds(List<Integer> ids);

    public int insertUser(User user);

    public int updateUser(User user);

    public int deleteUserById(Integer id);

}
