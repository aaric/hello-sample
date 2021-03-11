package com.example.hello.msg.impl;

import com.example.hello.msg.MailService;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 邮件服务接口实现
 *
 * @author Aaric, created on 2021-03-10T17:57.
 * @version 0.7.0-SNAPSHOT
 */
@Service
public class MailServiceImpl implements MailService {

    @Override
    public boolean send(@NonNull String subject, @NonNull String html, @NonNull List<String> to, String... cc) {
        return false;
    }
}
