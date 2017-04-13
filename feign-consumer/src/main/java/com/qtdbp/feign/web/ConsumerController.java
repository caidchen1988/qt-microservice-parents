package com.qtdbp.feign.web;

import com.qtdbp.feign.service.ComputeClient;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 创建ConsumerController来消费COMPUTE-SERVICE的add服务。通过直接RestTemplate来调用服务，计算10 + 20的值。
 * Created by dell on 2017/4/7.
 */
@Controller
//@RequestMapping(value = "/compute")
public class ConsumerController {

    @Autowired
    private ComputeClient computeClient ;

    @ApiOperation(value="计算数值服务", notes="创建ConsumerController来消费COMPUTE-SERVICE的add服务。通过直接RestTemplate来调用服务，计算10 + 20的值。")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Integer add() {
        return computeClient.add(10, 50);
    }

}
