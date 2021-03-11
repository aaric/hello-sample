package com.example.hello.msg;

import lombok.NonNull;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * 邮件服务接口
 *
 * @author Aaric, created on 2021-03-10T17:57.
 * @version 0.7.0-SNAPSHOT
 */
public interface MailService {

    /**
     * 发送文本邮件
     *
     * @param subject 主题
     * @param text    内容
     * @param to      发送人
     * @param cc      抄送人
     * @param bcc     密送人
     * @return
     */
    boolean sendText(@NonNull String subject, @NonNull String text, @NonNull List<String> to, List<String> cc, String... bcc);

    /**
     * 发送HTML邮件
     *
     * @param subject     主题
     * @param html        html
     * @param attachments 附件
     * @param to          发送人
     * @param cc          抄送人
     * @param bcc         密送人
     * @return
     */
    boolean sendHtml(@NonNull String subject, @NonNull String html, Map<String, File> attachments, @NonNull List<String> to, List<String> cc, String... bcc);
}
