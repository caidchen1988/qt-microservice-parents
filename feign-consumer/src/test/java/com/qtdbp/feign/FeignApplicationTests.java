package com.qtdbp.feign;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created with IntelliJ IDEA.
 * User: 浩
 * Date: 2017/4/11
 * Time: 21:08
 * To change this template use File | Settings | File Templates.
 */
public class FeignApplicationTests {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     *  BCryptPasswordEncoder管理密码
     */
    @Test
    public void testPass(){
        String pass = "abel@123";
        BCryptPasswordEncoder encode = new BCryptPasswordEncoder(4);
        String hashPass = encode.encode(pass);
        System.out.println(hashPass);
    }

    /**
     * 测试Logback日志
     */
    @Test
    public void testLog() {

        logger.debug("日志输出测试 Debug");
        logger.trace("日志输出测试 Trace");
        logger.info("日志输出测试 Info");

    }

}
