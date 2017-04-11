package com.qtdbp.feign.model;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created with IntelliJ IDEA.
 * User: chenhao
 * Date: 2017/4/9
 * Time: 21:37
 * To change this template use File | Settings | File Templates.
 */
@ApiModel(value = "User", description = "用户详细实体user")
public class User {

    @ApiModelProperty(name = "id", value = "id", dataType = "Long", hidden = true, required = true, position = 1)
    private Long id;
    @ApiModelProperty(name = "name", value = "名称", dataType = "String", position = 2)
    private String name;
    @ApiModelProperty(name = "age", value = "年龄", dataType = "Integer", position = 3)
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
