package com.meiyukai.dao;

import com.meiyukai.domain.Account;

import java.util.List;

public interface IAccountDao {

    /**
     * 查询所有的账户信息
     */

    public List<Account> findAll();

    /**
     * 根据ID查询账户
     */

    public Account findAccountById(Integer id);


    /**
     *  根据用户的ID查询Account
     */

    public List<Account> findAccountsByUserId(Integer uid);

    /*----------------------------------------------------------------------多表操作---------------------------------------------------------------------------*/


    /**
     * 查询账户以及对应的用户
     */

    List<Account> findAccountsAndUser();


    /**
     * 查询账户以及对应的用户
     */

    List<Account> findAccountsAndUser2();





}
