package com.qtdbp.feign.exception;

/**
 * 自定义异常处理
 *
 * Created by dell on 2017/4/11.
 */
public class GlobalException extends Exception {

    public GlobalException(String message) {
        super(message);
    }
}
