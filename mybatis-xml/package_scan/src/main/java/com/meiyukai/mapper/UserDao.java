package com.meiyukai.mapper;

import com.meiyukai.domain.User;
import com.meiyukai.provider.UserProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {

    /**
     * 查询所有的用户信息
     * @return
     */
    @SelectProvider(type = UserProvider.class , method = "findAllUsers" )
    List<User> findAll();

    /**
     * 根据ID 查询用户的信息
     */
    @SelectProvider(type = UserProvider.class , method="findUserById")
    User findUserById( @Param(value = "id") Integer id);

    /**
     * 模糊查询
     */
    @SelectProvider(type=UserProvider.class, method="findUserByName")
    List<User>  findUserByName(@Param(value="name") String name);


    /**
     * 添加用户信息
     */
    @InsertProvider(type=UserProvider.class , method= "addUser")
    void addUser(@Param(value = "user") User user);


    /**
     * 删除用户
     */
    @DeleteProvider(type=UserProvider.class , method = "deleteUserById")
    void deleteUserById(@Param(value = "id") Integer id);


    /**
     * 修改用户的信息
     */
    @UpdateProvider(type=UserProvider.class , method="updateUser")
    public void updateUser(@Param(value = "user") User user);







}
