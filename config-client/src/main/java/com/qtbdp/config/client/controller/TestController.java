package com.qtbdp.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dell on 2017/4/6.
 */
@RestController
public class TestController {

    @Value("${from}")
    private String from ;

    @RequestMapping("/from")
    public String from() {
        return from ;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
