package com.qtdbp.feign.web;

import com.qtdbp.feign.service.FileUploadClient;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: 浩
 * Date: 2017/4/13
 * Time: 23:19
 * To change this template use File | Settings | File Templates.
 */
@RestController
//@RequestMapping(value = "/file")
public class FileUploadController {

    @Autowired
    private FileUploadClient uploadClient ;

    @ApiOperation(value="文件上传服务", notes="创建ConsumerController来消费COMPUTE-SERVICE的add服务。通过直接RestTemplate来调用服务，计算10 + 20的值。")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String add() throws Exception {

        String url = uploadClient.upload(null,null,null) ;

        System.out.print("上传文件地址:"+url);
        return "home" ;
    }
}
