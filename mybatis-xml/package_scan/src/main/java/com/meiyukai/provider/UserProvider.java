package com.meiyukai.provider;

import com.meiyukai.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class UserProvider {

    /**
     * 查找所有的用户
     * @return
     */
    public String findAllUsers(){
        return new SQL(){{
            SELECT("*");
            FROM("user");
        }}.toString();
    }

    /**
     * 根据用户的ID查找用户
     */

    public String findUserById( Map<String , Object> map){
        final Object id = map.get("id");
        return new SQL(){{
            SELECT("*");
            FROM("user");
            WHERE("id=" +id);
        }}.toString();
    }

    /**
     * 模糊查询
     */

    public String findUserByName(Map<String , Object> map){
         final Object name = map.get("name");
        return new SQL(){{
            SELECT("*");
            FROM("user");
            WHERE("name like '%"+name+"%'");
        }}.toString();

    }

    /**
     * 添加用户信息
     */

    public String addUser(Map<String , Object>map){

        //这儿或者使用 StringBuilder StringBuffer 来拼接语句
        final User user = (User) map.get("user");
        return new SQL(){{
//            INSERT_INTO("user");
            INSERT_INTO("user");
            INTO_COLUMNS( "name","password","username");
            INTO_VALUES("'"+user.getName()+"'", "'"+user.getPassword()+"'","'"+user.getUsername()+"'");
//            VALUES("username",  "'"+user.getUsername()+"'");  //这种情况只适合插入一个数据
        }}.toString();
    }

    /**
     * 根据ID删除用户
     */

    public String deleteUserById(@Param(value = "id") final Integer id){
        return new SQL(){{
            DELETE_FROM("user");
            WHERE("id="+id);
        }}.toString();
    }

    /**
     * 修改用户的信息
     */
    public String updateUser(@Param(value = "user")  final User user){
        return new SQL(){{
            UPDATE("user");
            if (user.getName()!=null){
                SET("name="+"'"+user.getName()+"'");
            }
            if (user.getPassword()!=null){
                SET("password = "+"'"+user.getPassword()+"'");
            }
            if (user.getUsername()!=null){
                SET("username= "+"'"+user.getUsername()+"'");
            }
            WHERE("id="+user.getId());
        }}.toString();
    }





}
