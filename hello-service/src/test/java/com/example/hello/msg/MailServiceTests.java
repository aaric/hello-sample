package com.example.hello.msg;

import com.example.hello.TestApp;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
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

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private MailSender mailSender;

    @Autowired
    private MailService mailService;

    @Test
    public void testSendSimple() {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(from);
        msg.setTo("qlhan@incarcloud.com");
        msg.setSubject("hello world");
        msg.setText("<b>Ignore: test mail</b>");
        mailSender.send(msg);
    }

    @Test
    public void testSend() {

    }
}
