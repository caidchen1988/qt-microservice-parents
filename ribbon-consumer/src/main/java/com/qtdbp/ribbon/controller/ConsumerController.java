package com.qtdbp.ribbon.controller;

import com.qtdbp.ribbon.service.ComputeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 提供rest接口的Controller改为调用ComputeService的addService
 * Created by dell on 2017/4/7.
 */
@RestController
public class ConsumerController {

    @Autowired
    ComputeService computeService ;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return computeService.addService() ;
    }

    @RequestMapping("/")
    public String hello() {
        return "Hello Consumer!" ;
    }
}
