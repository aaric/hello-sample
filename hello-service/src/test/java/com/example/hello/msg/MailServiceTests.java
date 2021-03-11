package com.example.hello.msg;

import com.example.hello.TestApp;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;

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

    @Test
    public void testSendText() {
        mailService.sendText("hello text", "<b>Ignore: test mail</b>",
                Arrays.asList("qlhan@incarcloud.com"), null);
    }

    @Test
    public void testSendHtml() {
        mailService.sendHtml("hello html", "<b>Ignore: test mail</b>", null,
                Arrays.asList("qlhan@incarcloud.com"), null);
    }
}
