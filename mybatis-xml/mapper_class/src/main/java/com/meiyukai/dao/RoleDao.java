package com.meiyukai.dao;

import com.meiyukai.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

@CacheNamespace(blocking = true)
public interface RoleDao {

    /**
     * 查询所有的角色
     */

    @Select(value = "select * from role")
    @Results(id = "role_map" , value = {
            @Result(id = true  , property = "id" , column = "id"),
            @Result(property = "roleDesc" ,  column = "role_desc")
    })
    List<Role> findAllRoles();

    /**
     * 根据 ID查询role
     */

    @Select(value = "select * from role where id = #{id}" )
    @ResultMap(value = {"role_map"})
    Role findRoleById(@Param(value = "id") Integer id);

    /**
     * 根据 用户的ID查询role
     */
    @Select(value = "select * from role where id in (select role_id from user_role where user_id =#{user_id})")
    @ResultMap(value = {"role_map"})
    public List<Role> findRoleByUserId(@Param(value = "user_id") Integer id);

}
