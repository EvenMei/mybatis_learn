package com.meiyukai.dao;

import com.meiyukai.domain.Account;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.concurrent.BlockingQueue;

@CacheNamespace(blocking = true)
public interface AccountDao  {

    /**
     * 根据ID查询账户的信息
     */
    @Select(value = "select * from account where uid = #{id}")
    Account findAccountById(@Param(value="id") Integer id);

    /**
     * 打印所有的账户信息
     */
    @Select(value = "select * from account ")
    @Results(id = "account_user_map" , value = {
            @Result(id = true , property = "id" , column = "id"),
            @Result(property = "name" , column = "name"),
            @Result(property = "money" , column = "money"),
            @Result(property = "user" , column = "uid" , one = @One(select = "com.meiyukai.dao.UserDao.findUserById" , fetchType = FetchType.EAGER))
    })
    List<Account> findAllAccounts();



}
