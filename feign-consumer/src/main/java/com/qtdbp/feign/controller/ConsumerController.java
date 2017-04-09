package com.qtdbp.feign.controller;

import com.qtdbp.feign.service.ComputeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创建ConsumerController来消费COMPUTE-SERVICE的add服务。通过直接RestTemplate来调用服务，计算10 + 20的值。
 * Created by dell on 2017/4/7.
 */
@RestController
public class ConsumerController {

    @Autowired
    ComputeClient computeClient ;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add() {
        return computeClient.add(10, 50);
    }

    @RequestMapping("/")
    public String hello() {
        return "Hello Consumer!" ;
    }
}
