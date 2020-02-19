package com.meiyukai.dao;

import com.meiyukai.domain.User;
import com.meiyukai.pojo.QueryVo;

import java.util.List;

/**
 * 用户的持久层接口
 */
public interface IUserDao {

    List<User> findAll();

    void saveUser(User user);

    void updateUser(User user);
    /**
     * 根据id查询用户
     */
    User getUserById(Integer id);

    void deleteUserById(Integer id);

    int getCount();

    List<User>findByUserName(String username);

    List<User> findByQueryVo(QueryVo vo);

    List<User> findUserInIds(QueryVo vo);




}
