package com.qtbdp.provider;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dell on 2017/4/7.
 */
@EnableDiscoveryClient
@SpringBootApplication
@RestController
@Import(FdfsClientConfig.class)
public class ProviderServiceApplication {

    @RequestMapping("/")
    public String hello() {
        return "Hello Provider Service！" ;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProviderServiceApplication.class, args) ;
    }
}
