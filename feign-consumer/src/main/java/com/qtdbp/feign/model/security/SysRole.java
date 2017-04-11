package com.qtdbp.feign.model.security;

/**
 * 系统角色
 *
 * Created by dell on 2017/4/11.
 */
public class SysRole {

    private int id;
    private String name; //角色名称
    private SysUser SUser; //角色对应的用户实体

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SysUser getSUser() {
        return SUser;
    }

    public void setSUser(SysUser SUser) {
        this.SUser = SUser;
    }
}
