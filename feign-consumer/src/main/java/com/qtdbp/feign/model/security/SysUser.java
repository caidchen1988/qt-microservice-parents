package com.qtdbp.feign.model.security;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 系统用户
 *
 * Created by dell on 2017/4/11.
 */
public class SysUser implements java.io.Serializable {

    private Integer id;
    private String name; //用户名
    private String email;//用户邮箱
    private String password;//用户密码
    private Date date;//时间

    private Set<SysRole> SysRoles = new HashSet<SysRole>(0);// 所对应的角色集合

    public SysUser(String name, String email, String password, Date date, Set<SysRole> SysRoles) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.date = date;
        this.SysRoles = SysRoles;
    }

    public SysUser() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<SysRole> getSysRoles() {
        return SysRoles;
    }

    public void setSysRoles(Set<SysRole> sysRoles) {
        SysRoles = sysRoles;
    }
}
