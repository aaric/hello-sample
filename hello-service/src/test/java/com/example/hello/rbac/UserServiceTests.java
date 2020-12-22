package com.example.hello.rbac;

import com.example.hello.TestApp;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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
    private String applicationName;

    @Test
    public void testJson() {
        log.info("applicationName: {}", applicationName);
    }
}
