package com.example.hello.msg.impl;

import com.example.hello.msg.MailService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 邮件服务接口实现
 *
 * @author Aaric, created on 2021-03-10T17:57.
 * @version 0.7.0-SNAPSHOT
 */
@Slf4j
@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private MailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    /**
     * List<String> 转 String[]
     *
     * @param strings 字符串集合
     * @return
     */
    private String[] toArray(List<String> strings) {
        return strings.toArray(new String[]{});
    }

    @Override
    public boolean sendText(@NonNull String subject, @NonNull String text, @NonNull List<String> to, List<String> cc, String... bcc) {
        try {
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setFrom(from);
            msg.setTo(toArray(to));
            if (null != cc && 0 != cc.size()) {
                msg.setCc(toArray(cc));
            }
            if (null != bcc && 0 != bcc.length) {
                msg.setBcc(bcc);
            }
            msg.setSubject(subject);
            msg.setText(text);
            mailSender.send(msg);

            return true;
        } catch (Exception e) {
            log.error("sendSimple exception", e);
        }
        return false;
    }

    @Override
    public boolean sendHtml(@NonNull String subject, @NonNull String html, @NonNull List<String> to, List<String> cc, String... bcc) {
        return false;
    }
}
