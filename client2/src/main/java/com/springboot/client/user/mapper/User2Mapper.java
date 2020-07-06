package com.springboot.client.user.mapper;


import com.springboot.client.user.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface User2Mapper {
    /**
     * 登录（直接使用注解指定传入参数名称）
     * @param userName
     * @param password
     * @return
     */
    public User login(@Param("user_Name") String userName, @Param("password") String password);

    /**
     * 根据表名查询用户信息（直接使用注解指定传入参数名称）
     * @param tableName
     * @return
     */
    public List<User> queryUserByTableName(@Param("tableName") String tableName);

    /**
     * 根据Id查询用户信息
     * @param id
     * @return
     */
    public User queryUserById(int id);

    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> queryUserAll();

    /**
     * 根据用户名查询用户信息
     * @param name
     * @return
     */
    public List<User> queryByName(@Param("name") String name);

    /**
     * 查询男性用户，如果输入了姓名则按照姓名模糊查找，否则如果输入了年龄则按照年龄查找，否则查找姓名为“静静”的用户。
     * @param name
     * @param age
     * @return
     */
    public List<User> queryByNameOrAge(@Param("name") String name, @Param("age") Integer age);

    /**
     * 查询所有用户，如果输入了姓名按照姓名进行模糊查询，如果输入年龄，按照年龄进行查询，如果两者都输入，两个条件都要成立
     * @param name
     * @param age
     * @return
     */
    public List<User> queryByNameOrAge2(@Param("name") String name, @Param("age") Integer age);

    /**
     * 按照多个id查询用户信息
     * @param ids
     * @return
     */
    public List<User> queryByIds(@Param("ids") List<Integer> ids);

    /**
     * 新增用户信息
     * @param user
     */
    public int insertUser(User user);

    /**
     * 根据id更新用户信息
     * @param user
     */
    public int updateUser(User user);

    /**
     * 根据id删除用户信息
     * @param id
     */
    public int deleteUserById(int id);

}

