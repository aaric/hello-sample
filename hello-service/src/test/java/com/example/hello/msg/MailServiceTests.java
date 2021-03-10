package com.example.hello.msg;

import com.example.hello.TestApp;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * MailServiceTests
 *
 * @author Aaric, created on 2021-03-10T17:59.
 * @version 0.7.0-SNAPSHOT
 */
@Slf4j
@SpringBootTest(classes = TestApp.class)
@ExtendWith(SpringExtension.class)
public class MailServiceTests {

    @Autowired
    private MailService mailService;
}
