package com.meiyukai.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
//    private Integer id;
    private Integer ids;
    private String username;
    private String address;
    private Date birthday;
    private String sex;

    public  User(){

    }
   /* public User(Integer id,String username, String address, Date birthday , String sex){
        this.id = id;
        this.username = username;
        this.address = address;
        this.sex = sex;
        this.birthday = birthday;
    }*/
    public User(Integer ids,String username, String address, Date birthday , String sex){
        this.ids = ids;
        this.username = username;
        this.address = address;
        this.sex = sex;
        this.birthday = birthday;
    }

    /*public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }*/


    public Integer getIds() {
        return ids;
    }

    public void setId(Integer ids) {
        this.ids= ids;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + ids +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                '}';
    }
}
