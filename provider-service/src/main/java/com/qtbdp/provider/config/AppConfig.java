package com.qtbdp.provider.config;

import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: 浩
 * Date: 2017/4/13
 * Time: 23:16
 * To change this template use File | Settings | File Templates.
 */
@Component
public class AppConfig {

    public String getResHost() {
        return "192.168.36.39" ;
    }

    public String getFdfsStoragePort() {
        return "2300" ;
    }
}
