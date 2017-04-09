package com.qtbdp.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dell on 2017/4/6.
 */
@RefreshScope
@RestController
public class TestController {

    @Value("${from}")
    private String from ;

    @RequestMapping("/from")
    public String from() {
        return from ;
    }

    /*@RequestMapping(value = "/bus/refresh",method = RequestMethod.POST)
    public boolean refresh() {
        return true ;
    }*/
}
