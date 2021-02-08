package com.example.hello.core;

/**
 * 常量类
 *
 * @author Aaric, created on 2020-12-18T15:58.
 * @version 0.2.0-SNAPSHOT
 */
public interface Constants {

    /**
     * 状态码
     */
    interface ApiCode {

        /**
         * 响应码：200-请求成功
         */
        int SUCCESS = 200;

        /**
         * 响应码：500-默认异常
         */
        int ERROR_500 = 500;

        /**
         * 响应码：600-校验异常
         */
        int ERROR_600 = 600;
    }
}
