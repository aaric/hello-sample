package com.example.hello.api.test.impl;

import com.example.hello.api.test.TestApi;
import com.example.hello.data.ApiData;
import com.example.hello.data.ApiException;
import com.example.hello.pojo.ValidBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

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
    public ApiData<String> hello(@RequestParam(required = false) String msg) throws Exception {
        if (StringUtils.isBlank(msg)) {
            throw new ApiException(10001, "fake!!!");
        }

        return new ApiData<String>()
                .setData(msg);
    }

    @Override
    @GetMapping(value = "/text2json", produces = MediaType.APPLICATION_JSON_VALUE)
    public String text2json() throws Exception {
        return "{\"application\": \"hello-web-admin\",\"version\": \"0.4.0-SNAPSHOT\"}";
    }

    @Override
    @PostMapping("/form")
    public ApiData<Date> form(@RequestParam Date creationTime) throws Exception {
        log.info("form | creationTime={}", creationTime);
        creationTime = new Date();
        return new ApiData<Date>()
                .setData(creationTime);
    }

    @Override
    @PostMapping("/valid")
    public ApiData<Long> valid(@Valid @RequestBody ValidBean validBean) throws Exception {
        log.info("valid | validBean={}", validBean);
        return new ApiData<Long>()
                .setData(1L);
    }
}
