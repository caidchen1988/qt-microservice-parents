package com.qtdbp.feign.model.security;

/**
 * 系统资源
 *
 * Created by dell on 2017/4/11.
 */
public class SysResource {

    private int id;
    private String resourceString;//url
    private String resourceId;//资源ID
    private String remark;//备注
    private String resourceName;//资源名称
    private String methodName;//资源所对应的方法名
    private String methodPath;//资源所对应的包路径

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResourceString() {
        return resourceString;
    }

    public void setResourceString(String resourceString) {
        this.resourceString = resourceString;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodPath() {
        return methodPath;
    }

    public void setMethodPath(String methodPath) {
        this.methodPath = methodPath;
    }
}
