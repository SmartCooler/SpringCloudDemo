package com.springboot.client.user.controller;

import com.springboot.client.user.pojo.User;
import com.springboot.client.user.service.UserService;
import com.springboot.client.utils.exception.UnicomRuntimeException;
import com.springboot.client.utils.response.ResponseBean;
import com.springboot.client.utils.response.UnicomResponseEnums;
import com.springboot.common.utils.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@Api(value = "swagger_user")
@RequestMapping("/user")
@RestController
public class UserController {

    private static Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ApiOperation(value="swagger_addUser")
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public ResponseBean<String> addUser (){
        int res = 0;
        try{
            User user = new User();
            user.setName("刘德华");
            user.setPassword("0000002");
            user.setSex(1);
            user.setBirthday(new Date());
            res = userService.insert(user);
        }catch (Exception e){
            logger.error("新增失败！",e);
            throw new UnicomRuntimeException(UnicomResponseEnums.BAD_REQUEST);
        }
        return new ResponseBean(true,res,UnicomResponseEnums.SUCCESS_OPTION);
    }

    @ApiOperation(value="swagger_selectAll")
    @RequestMapping(value = "/selectAll",method = RequestMethod.GET)
    public String selectAll(){
        List<User> list = userService.selectAll();
        list.stream().forEach(System.out::println);
        return list.toString();
    }

    @RequestMapping(value = "/selectById/{id}",method = RequestMethod.GET)
    public String selectById(@PathVariable int id){
        User user = userService.selectById(id);
        return user.toString();
    }

    @ApiOperation(value="swagger_delete")
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public String delete(){
        int res = userService.delete(107);
        return res + "";
    }

    @ApiOperation(value="swagger_update")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(){
        int res = userService.update("Andy",23,2,107);
        return res + "";
    }

    @ApiOperation(value="swagger_test")
    @RequestMapping(value = "/test/{flag}",method = RequestMethod.GET)
    public ResponseBean<UnicomResponseEnums> swagger_test(@PathVariable String flag){
        try{
            if(StringUtils.isNotEmpty(flag)){
                if(("1").equals(flag)){
                    return new ResponseBean(true,UnicomResponseEnums.SUCCESS_OPTION);
                }else if(("2").equals(flag)){
                    return new ResponseBean(true,new User(),UnicomResponseEnums.BAD_REQUEST);
                }else{
                    return  new ResponseBean(true,new Date("hsdfhksj"),UnicomResponseEnums.SUCCESS_OPTION);
                }
            }else{
                return new ResponseBean(false,UnicomResponseEnums.BAD_REQUEST);
            }
        }catch (Exception e){
            logger.error("很抱歉，操作失败了！",e);
            throw new UnicomRuntimeException(UnicomResponseEnums.BAD_REQUEST);
        }
    }

}
