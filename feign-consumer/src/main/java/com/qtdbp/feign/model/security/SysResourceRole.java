package com.qtdbp.feign.model.security;

import java.util.Date;

/**
 * 系统资源角色关系
 *
 * Created by dell on 2017/4/11.
 */
public class SysResourceRole {

    private int id;
    private String roleId; //角色ID
    private String resourceId;//资源ID
    private Date updateTime;//更新时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
