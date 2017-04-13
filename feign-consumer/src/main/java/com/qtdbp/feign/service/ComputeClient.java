package com.qtdbp.feign.service;

import com.qtdbp.feign.service.impl.ComputeClientHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 定义pro-service服务的接口
 *
 * @FeignClient("pro-service")注解来绑定该接口对应pro-service服务,@FeignClient注解中的fallback属性指定回调类
 * Created by dell on 2017/4/7.
 */
@FeignClient(value = "PRO-SERVICE", fallback = ComputeClientHystrix.class)
public interface ComputeClient {

    @RequestMapping(method = RequestMethod.GET, value = "/add")
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);

}
