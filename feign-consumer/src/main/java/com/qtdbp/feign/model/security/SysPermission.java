package com.qtdbp.feign.model.security;

import java.util.Date;

/**
 * 系统权限表
 *
 * Created by dell on 2017/4/11.
 */
public class SysPermission {

    private int id;
    private int pid ;       // 父ID
    private String code;    //权限编码
    private String desc;    //权限描述
    private String url;     //地址
    private String method;  //方法
    private Date created;   //创建时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
