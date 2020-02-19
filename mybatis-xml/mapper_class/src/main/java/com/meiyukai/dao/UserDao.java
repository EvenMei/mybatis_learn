package com.meiyukai.dao;

import com.meiyukai.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/*UserDao 使用二级缓存
* 注解中开发使用二级缓存只需要两步
* 1. 全局 settings
* 2.@CacheNamespace(blocking = true)
*
* */
@CacheNamespace(blocking = true)

public interface UserDao {


    /**
     * 查询所有的用户
     * @return
     */
    @Select(value = "select * from user ")
    List<User> findAll();


    /**
     * 根据ID查询用户的信息
     * @param id
     * @return
     */
    @Select(value = "select * from user where id = #{id}")
    User findUserById(Integer id);


    /**
     * 插入用户的信息
     * id 使用auto_increment , 不需要认为设定
     */

    @Insert(value = "insert into user values(null,#{name},#{password},#{username})")
    void addUser(User user);

    /**
     * 更新用户的信息
     * @param user
     */
    @Update(value="update user set name=#{name},password = #{password} , username=#{username} where id = #{id}")
    void updateUser(User user);

    /**
     * 模糊查询
     */
    @Select(value="select * from user where username like'%${username}%'")
    List<User> findUserByName(@Param(value = "username") String username);

    /**
     * 删除用户
     */
    @Delete(value="delete from user where id  = #{id}")
    void deleteUserById(Integer id);


    /**
     * 查询用户的总数
     */
    @Select(value="select count(1) from user ")
    Integer findTotalUsers();



    /*---------------------------------------------------------------------多表操作----------------------------------------------------------------------------*/
    @Select(value = "select * from user")
    @Results(value = {
            @Result(id = true , property = "id",  column = "id"  ),
            @Result(property = "name"  ,  column = "name"),
            @Result(property = "username"  ,  column = "username"),
            @Result(property = "password"  ,  column = "password"),
            @Result(property = "accounts" , column = "id" , many = @Many(select = "com.meiyukai.dao.AccountDao.findAccountById" , fetchType = FetchType.LAZY))
    })
    public List<User> findAllUsersAndAccounts();



    @Select(value = "select * from user")
    @Results(id = "user_role_map" , value = {
            @Result(id = true , property = "id",  column = "id"  ),
            @Result(property = "name"  ,  column = "name"),
            @Result(property = "username"  ,  column = "username"),
            @Result(property = "password"  ,  column = "password"),
            @Result(property = "roles" , column = "id" , many = @Many(select = "com.meiyukai.dao.RoleDao.findRoleByUserId" , fetchType = FetchType.LAZY))
    })
    public List<User> findAllUsersAndRoles();

}
