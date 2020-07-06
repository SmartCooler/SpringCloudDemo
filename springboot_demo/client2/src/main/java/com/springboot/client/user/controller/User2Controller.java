package com.springboot.client.user.controller;

import com.springboot.client.user.pojo.User;
import com.springboot.client.user.service.User2Service;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping("/user6")
@RestController
public class User2Controller {

    private static Logger logger = Logger.getLogger(User2Controller.class);

    @Autowired
    HttpServletRequest httpServletRequest;

    @Autowired
    private User2Service user2Service;

    @RequestMapping("/login")
    public String login() {
        System.out.println(user2Service.login("hj", "123456"));
        return user2Service.login("hj", "123456").toString();
    }

    @RequestMapping("/queryUserByTableName")
    public String queryUserByTableName() {
        List<User> userList = user2Service.queryUserByTableName("tb_user");
        for (User user : userList) {
            System.out.println(user);
        }
        return userList.toString();
    }

    @RequestMapping("/queryUserById")
    public String queryUserById() {
        System.out.println(user2Service.queryUserById(100));

//        mybatis具有一级缓存，重复进行相同的查询语句和参数，首先会从缓存中命中读取结果，如果没有命中则重新查询
//        session.clearCache();
//        System.out.println(user2Service.queryUserById(100));

        return user2Service.queryUserById(100).toString();
    }

    @RequestMapping("/queryUserAll")
    public String queryUserAll() {
        List<User> userList = user2Service.queryUserAll();
        for (User user : userList) {
            System.out.println(user);
        }
        return userList.toString();
    }

    @RequestMapping("/queryByName")
    public String queryByName(){
        String name = httpServletRequest.getParameter("userName");
        List<User> userList = user2Service.queryByName(name);
        logger.info("info");
        logger.debug("debug");
        logger.warn("warn");
        logger.error("error");
        for (User user : userList) {
            System.out.println(user);
        }
        return userList.toString();
    }
    @RequestMapping("/queryByNameOrAge")
    public void queryByNameOrAge(){
        List<User> userList = user2Service.queryByNameOrAge("静静",22);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @RequestMapping("/queryByNameOrAge2")
    public String queryByNameOrAge2(){
        List<User> userList = user2Service.queryByNameOrAge2("静静",22);
        for (User user : userList) {
            System.out.println(user);
        }
        return userList.toString();
    }

    @RequestMapping("/queryByIds")
    public String queryByIds(){
//        1.入参是List类型
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(100);
        ids.add(102);
//        2.入参是数组类型
//        int[] ids = new int[]{100,102};
        List<User> userList = user2Service.queryByIds(ids);
        for(User user : userList){
            System.out.println(user);
        }
        return userList.toString();
    }

    @RequestMapping("/insertUser")
    public int insertUser() {
        User user = new User();
        user.setAge(20);
        user.setBirthday(new Date());
        user.setName("大神");
        user.setPassword("123456");
        user.setSex(2);
        user.setUserName("bigGod222");
        System.out.println(user2Service.insertUser(user));
        return user2Service.insertUser(user);
    }

    @RequestMapping("/updateUser")
    public int updateUser() {
        User user = new User();
        user.setBirthday(new Date());
        user.setName("梦梦");
        user.setPassword("123456567");
        user.setSex(0);
        user.setUserName("mengmeng");
        user.setId("103");
        int res = user2Service.updateUser(user);
        System.out.println(res);
        return res;
    }

    @RequestMapping("/deleteUserById/{id}")
    public int deleteUserById(@PathVariable int id) {
        int res = user2Service.deleteUserById(id);
        System.out.println(res);
        return res;
    }

}
