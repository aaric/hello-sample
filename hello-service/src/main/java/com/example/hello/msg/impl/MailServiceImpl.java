package com.example.hello.msg.impl;

import com.example.hello.msg.MailService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 邮件服务接口实现
 *
 * @author Aaric, created on 2021-03-10T17:57.
 * @version 0.7.0-SNAPSHOT
 */
@Slf4j
@Service
public class MailServiceImpl implements MailService {

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private JavaMailSender javaMailSender;

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
    public boolean sendText(@NonNull String subject, @NonNull String text, @NonNull String... to) {
        return sendText(subject, text, Arrays.asList(to), null);
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

            javaMailSender.send(msg);
            return true;

        } catch (Exception e) {
            log.error("sendSimple exception", e);
        }
        return false;
    }

    @Override
    public boolean sendHtml(@NonNull String subject, @NonNull String html, Map<String, File> attachments, String... to) {
        return sendHtml(subject, html, attachments, Arrays.asList(to), null);
    }

    @Override
    public boolean sendHtml(@NonNull String subject, @NonNull String html, Map<String, File> attachments, @NonNull List<String> to, List<String> cc, String... bcc) {
        try {
            MimeMessage msg = javaMailSender.createMimeMessage();

            MimeMessageHelper helper;
            if (null != attachments && 0 != attachments.size()) {
                helper = new MimeMessageHelper(msg, true);
            } else {
                helper = new MimeMessageHelper(msg);
            }

            helper.setFrom(from);
            helper.setTo(toArray(to));
            if (null != cc && 0 != cc.size()) {
                helper.setCc(toArray(cc));
            }
            if (null != bcc && 0 != bcc.length) {
                helper.setBcc(bcc);
            }

            helper.setSubject(subject);
            helper.setText(html, true);

            if (null != attachments && 0 != attachments.size()) {
                attachments.forEach((key, value) -> {
                    try {
                        helper.addAttachment(key, value);
                    } catch (MessagingException e) {
                        log.error("sendHtml addAttachment exception", e);
                    }
                });
            }

            javaMailSender.send(helper.getMimeMessage());
            return true;

        } catch (Exception e) {
            log.error("sendHtml exception", e);
        }
        return false;
    }
}
