package com.qtdbp.feign;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created with IntelliJ IDEA.
 * User: 浩
 * Date: 2017/4/11
 * Time: 21:08
 * To change this template use File | Settings | File Templates.
 */
public class FeignApplicationTests {

    /**
     *  BCryptPasswordEncoder管理密码
     */
    @Test
    public void testPass(){
        String pass = "123456";
        BCryptPasswordEncoder encode = new BCryptPasswordEncoder(4);
        String hashPass = encode.encode(pass);
        System.out.println(hashPass);
    }
}
