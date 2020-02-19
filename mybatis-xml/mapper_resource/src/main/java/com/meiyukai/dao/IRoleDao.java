package com.meiyukai.dao;

import com.meiyukai.domain.Role;

import java.util.List;

public interface IRoleDao {

    /**
     * 查找所有的role
     */

    List<Role> findAllRoles();


    /**
     * 根据ID查询role
     */
    Role findRoleById(Integer id);

    /**
     * 根据用户的ID查询role
     */
    public List<Role> findRolesByUserId(Integer uid );



}
