package com.qtdbp.feign.model.security;

import java.util.HashSet;
import java.util.Set;

/**
 * 系统角色
 *
 * Created by dell on 2017/4/11.
 */
public class SysRole {

    private int id;
    private String name; //角色名称
    private String code; // 角色编码

    private Set<SysPermission> sysPermissions = new HashSet<SysPermission>(0);// 所对应的权限集合

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Set<SysPermission> getSysPermissions() {
        return sysPermissions;
    }

    public void setSysPermissions(Set<SysPermission> sysPermissions) {
        this.sysPermissions = sysPermissions;
    }
}
