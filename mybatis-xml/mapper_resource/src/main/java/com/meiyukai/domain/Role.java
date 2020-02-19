package com.meiyukai.domain;

import java.io.Serializable;

public class Role implements Serializable {
    private Integer id;
    private String roleDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleDesc='" + roleDesc + '\'' +
                '}';
    }
}
