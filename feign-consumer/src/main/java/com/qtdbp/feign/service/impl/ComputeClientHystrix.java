package com.qtdbp.feign.service.impl;

import com.qtdbp.feign.service.ComputeClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 创建回调类ComputeClientHystrix，实现@FeignClient的接口。
 * Created by dell on 2017/4/7.
 */
@Component
public class ComputeClientHystrix implements ComputeClient {

    /**
     * 实现的方法就是对应@FeignClient接口中映射的fallback函数。
     * @param a
     * @param b
     * @return
     */
    public Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        return -9999 ;
    }
}
