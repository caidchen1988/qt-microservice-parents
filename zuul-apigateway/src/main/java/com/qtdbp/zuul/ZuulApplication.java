package com.qtdbp.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * @SpringCloudApplication注解整合了@SpringBootApplication、@EnableDiscoveryClient、@EnableCircuitBreaker
 * Created by dell on 2017/4/7.
 */
@EnableZuulProxy
@SpringCloudApplication
public class ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args) ;
//        new SpringApplicationBuilder(ZuulApplication.class).web(true).run(args);
    }

    /**
     * http://localhost:5555/api-b/add?a=1&b=20&accessToken=token
     * @return
     */
    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter() ;
    }
}
