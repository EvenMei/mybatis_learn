package com.meiyukai.dao;

import com.meiyukai.domain.User;

import java.util.List;

/**
 * 用户的持久层接口 ( 参考 mapper_resource)
 */
public interface IUserDao {

    List<User> findAll();


}
