package com.qtdbp.feign.web;

import com.qtdbp.feign.mapper.UserMapper;
import com.qtdbp.feign.model.User;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.*;

/**
 * 构建RESTful API
 * Created with IntelliJ IDEA.
 * User: 浩
 * Date: 2017/4/9
 * Time: 22:30
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserMapper userMapper ;

    @ApiOperation(value="获取用户列表", notes="处理\"/users/\"的GET请求，用来获取用户列表")
    @RequestMapping(value={""}, method= RequestMethod.GET)
    public List<User> getUserList() {
        // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递

        List<User> r = userMapper.findAll() ;
        return r;
    }

    @ApiOperation(value="获取用户列表", notes="处理\"/users/\"的GET请求，用来获取用户列表")
    @RequestMapping(value={""}, method= RequestMethod.GET)
    public String getUserList(ModelMap map) {
        // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递

        List<User> r = userMapper.findAll() ;

        map.put("users", r) ;
        map.put("host", "http://www.cnblogs.com/vinphy/p/4674247.html") ;
        return "user-list";
    }

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @RequestMapping(value="", method=RequestMethod.POST)
    public String postUser(@ModelAttribute User user) {
        // 处理"/users/"的POST请求，用来创建User
        // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数

        userMapper.insert(user) ;
        return "success";
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
        // url中的id可通过@PathVariable绑定到函数的参数中
        return userMapper.findById(id) ;
    }

    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String putUser(@ModelAttribute User user) {
        // 处理"/users/{id}"的PUT请求，用来更新User信息
        int row = userMapper.updateById(user) ;

        return row > 0 ? "success" : "fail" ;
    }

    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        // 处理"/users/{id}"的DELETE请求，用来删除User

        boolean success = userMapper.deleteById(id) ;

        return success ? "success" : "fail" ;
    }
}
