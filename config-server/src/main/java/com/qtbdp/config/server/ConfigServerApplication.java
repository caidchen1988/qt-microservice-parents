package com.qtbdp.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @EnableDiscoveryClient注解，用来将config-server注册到上面配置的服务注册中心上去
 * @Configuration是spring定义的注解，使用注解，配置信息的载体由 XML 文件转移到了 Java 类中。
   @EnableAutoConfiguration是spring boot定义的注解，控制spring applicationContext的自动配置的开关。
   @EnableConfigServer是spring cloud定义的注解，
 *
 * Created by dell on 2017/4/5.
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableConfigServer
@RestController
public class ConfigServerApplication {

    /**
     * 启动
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args) ;
    }
}
