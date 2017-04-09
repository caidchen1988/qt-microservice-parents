package com.qtbdp.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by dell on 2017/4/6.
 */
@EnableEurekaServer
@SpringBootApplication
public class EureKaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EureKaServerApplication.class, args) ;
//        new SpringApplicationBuilder(EureKaServerApplication.class).run(args) ;
    }
}
