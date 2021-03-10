package com.example.hello.msg;

import lombok.NonNull;

import java.util.List;

/**
 * 邮件服务接口
 *
 * @author Aaric, created on 2021-03-10T17:57.
 * @version 0.7.0-SNAPSHOT
 */
public interface MailService {

    /**
     * 发送邮件
     *
     * @param subject 主题
     * @param html    内容
     * @param to      发送人
     * @param cc      抄送人
     * @return
     */
    boolean send(@NonNull String subject, @NonNull String html, @NonNull List<String> to, String... cc);
}
