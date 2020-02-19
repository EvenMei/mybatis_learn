package com.meiyukai.dao;

import com.meiyukai.domain.User;

import java.util.List;

/**
 * 用户的持久层接口
 */
public interface IUserDao {

    /**
     * 查询所有
     * @return
     */
    List<User> findAll();


    /**
     * 条件查询
     */
    User findUserById(Integer id);

    /**
     * 添加新的用户
     */
    public void addUser(User user);


    /**
     * 更新用户
     */
    public void updateUser(User user);


    /**
     * 删除用户
     */
    public void deleteUserById(Integer id);

    /**
     * 根据用户的姓名查询用户的信息
     */
    public List<User> findByUserName(String username);

    /*---------------------------------------------------------------------多表操作---------------------------------------------------------------------------*/


    /**
     * 查询所有的用户以及其账户
     */
    public List<User> findAllUsersAndAccounts();


    /**
     * 查询所有的用户以及其账户
     */
    public List<User> findAllUsersAndAccounts2();


    /**
     * 查询所有的user 和 role
     */

    public List<User> findAllUsersAndRoles();

    /**
     * 查询所有的user 和 role
     */

    public List<User> findAllUsersAndRoles2();











}
