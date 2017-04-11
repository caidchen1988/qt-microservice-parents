package com.qtdbp.feign.web;

import com.qtdbp.feign.exception.GlobalException;
import com.qtdbp.feign.model.User;
import com.qtdbp.feign.service.ComputeClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 注意：@RestController以字符串的形式渲染结果，启动服务后在浏览器上访问本地项目地址，显示得到是return中的hello字符串。
 * 如果把@RestController改成@Controller，以为使用了Thymeleaf模板，它就会在/resources/templates中渲染对于return的hello.html。
 *
 * Created by dell on 2017/4/11.
 */
@Api(description="首页业务数据处理")
@Controller
@RequestMapping(value = "/hello")
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(HelloController.class);


    /**
     * 测试hello
     * @return
     */
    @ApiOperation(value="计算数值服务", notes="创建ConsumerController来消费COMPUTE-SERVICE的add服务。通过直接RestTemplate来调用服务，计算10 + 20的值。")
    @RequestMapping(value = "/{name}/{age}",method = RequestMethod.GET)
    public ModelAndView hello(@PathVariable("name") String name, @PathVariable("age") String age) {

        Map<String,Object> map = new HashMap<String,Object>() ;
        map.put("name", name) ;
        map.put("age", age) ;

        return new ModelAndView("hello", map) ;
    }

    @ApiOperation(value="计算数值服务", notes="创建ConsumerController来消费COMPUTE-SERVICE的add服务。通过直接RestTemplate来调用服务，计算10 + 20的值。")
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String hello(@ModelAttribute("user") User user) {

        Map<String,Object> map = new HashMap<String,Object>() ;
        map.put("name", user.getName()) ;
        map.put("age", user.getAge()) ;

        return "hello";
    }

    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public String json() throws GlobalException {
        throw new GlobalException("发生错误");
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String hello() throws Exception {
        throw new Exception("发生错误");
    }


    /*@ApiOperation(value="获取用户列表", notes="处理\"/users/\"的GET请求，用来获取用户列表")
    @RequestMapping(value={""}, method= RequestMethod.GET)
    public String getUserList(ModelMap map) {
        // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递

        List<User> r = userMapper.findAll() ;

        map.put("users", r) ;
        map.put("host", "http://www.cnblogs.com/vinphy/p/4674247.html") ;
        return "user-list";
    }*/


}
