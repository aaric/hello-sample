package com.example.hello.rbac;

import com.example.hello.TestApp;
import com.example.hello.pojo.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

/**
 * UserServiceTests
 *
 * @author Aaric, created on 2020-12-22T15:50.
 * @version 0.4.0-SNAPSHOT
 */
@Slf4j
@SpringBootTest(classes = TestApp.class)
@ExtendWith(SpringExtension.class)
public class UserServiceTests {

    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testAppName() {
        log.info("appName: {}", appName);
        Assertions.assertEquals("hello-service", appName);
    }

    @Test
    public void testJackson() throws Exception {
        User user = new User()
                .setId(1L)
                .setUsername("admin")
                .setPassword("123456")
                .setPasswordSalt("abc")
                .setName("超级管理员")
                .setSex(0)
                .setBirthday(new Date());
        String json = objectMapper.writeValueAsString(user);
        log.info("{}", json);
        Assertions.assertNotNull(json);

        User newUser = objectMapper.readValue(json, User.class);
        log.info("{}", newUser);
        Assertions.assertNotNull(newUser);
    }
}
