package com.example.hello.api.test.impl;

import com.example.common.data.ResponseData;
import com.example.hello.api.test.TestApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试模块API控制器
 *
 * @author Aaric, created on 2020-12-18T15:13.
 * @version 0.2.0-SNAPSHOT
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/admin/test/test")
public class TestController implements TestApi {

    @Override
    @GetMapping("/hello")
    public ResponseData<String> hello(String msg) {
        return new ResponseData<String>()
                .setData(msg);
    }
}
