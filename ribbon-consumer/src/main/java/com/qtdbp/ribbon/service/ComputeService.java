package com.qtdbp.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 新增ComputeService类，在使用ribbon消费服务的函数上增加@HystrixCommand注解来指定回调方法
 * Created by dell on 2017/4/7.
 */
@Service
public class ComputeService {

    @Autowired
    RestTemplate restTemplate ;

    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public String addService() {
        return restTemplate.getForEntity("http://PRO-SERVICE/add?a=10&b=20", String.class).getBody() ;
    }

    public String addServiceFallback() {
        return "error" ;
    }
}
