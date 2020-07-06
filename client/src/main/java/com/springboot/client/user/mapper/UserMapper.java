package com.springboot.client.user.mapper;

import com.springboot.client.user.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    //新增
    @Insert(" insert into tb_user(user_Name,password,name,age,sex,birthday,created,updated) " +
            " value(#{user_Name},#{password},#{name},#{age},#{sex},#{birthday},now(),now()) ")
    int insert(User user);

    //根据id删除一个用户
    @Delete(" delete from tb_user where id = #{id} ")
    int delete(Integer id);

    //根据id更改用户信息
    @Update(" update tb_user set name = #{name}, age = #{age}, sex = #{sex} where id = #{id} ")
    int update(String name, Integer age, Integer sex, Integer id);

    //查询一个用户信息
    @Select(" select id,name,age from tb_user where id = #{id} ")
    User selectById(Integer id);

    //查询所有的用户信息
    @Select(" select id,name,age from tb_user ")
    List<User> selectAll();

}
