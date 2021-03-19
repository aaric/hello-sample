package com.example.hello.msg;

import com.example.hello.TestApp;
import com.example.hello.utils.FreeMarkerUtil;
import com.example.hello.utils.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 * MailServiceTests
 *
 * @author Aaric, created on 2021-03-10T17:59.
 * @version 0.7.0-SNAPSHOT
 */
@Disabled
@Slf4j
@SpringBootTest(classes = TestApp.class)
@ExtendWith(SpringExtension.class)
public class MailServiceTests {

    @Autowired
    private MailService mailService;

    @Test
    public void testSendText() {
//        mailService.sendText("hello text", "<b>Ignore: test mail</b>",
//                Arrays.asList("qlhan@incarcloud.com"), null);
        mailService.sendText("hello text", "<b>Ignore: test mail</b>", "qlhan@incarcloud.com");
    }

    @Test
    public void testSendHtml() throws FileNotFoundException {
        Map<String, File> attachments = new HashMap<>();
        attachments.put("application.yml", ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "application.yml"));
//        mailService.sendHtml("hello html", "<b>Ignore: test mail</b>", attachments,
//                Arrays.asList("qlhan@incarcloud.com"), null);
        mailService.sendHtml("hello html", "<b>Ignore: test mail</b>", attachments, "qlhan@incarcloud.com");
    }

    @Test
    public void testSendTemplate() throws Exception {
        Map<String, String> data = new HashMap<>();
        data.put("code", RandomUtil.nextText(6, false));
        data.put("minutes", "30");

        String html = FreeMarkerUtil.process2String("send_auth_code.flt", data);
        mailService.sendHtml("验证码", html, null, "qlhan@incarcloud.com");
    }
}
