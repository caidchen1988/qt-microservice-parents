package com.qtbdp.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * Created by dell on 2017/4/5.
 */
@SpringBootApplication
@RestController
public class ConfigClientApplication {

    @Value("${from}")
    String bar ;

    @RequestMapping("/")
    public String showLuckyWord() {
        return "The lucky word is: " + bar;
    }

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args) ;
//        new SpringApplicationBuilder(ConfigClientApplication.class).web(true).run(args) ;
    }
}
