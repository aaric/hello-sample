package com.example.hello.util;

import org.springframework.mail.javamail.ConfigurableMimeFileTypeMap;

/**
 * MimeType工具类
 *
 * @author Aaric, created on 2021-06-03T13:38.
 * @version 0.11.0-SNAPSHOT
 */
public class MimeTypeUtils {

    /**
     * 使用spring支持MimeFile加载类
     */
    private static ConfigurableMimeFileTypeMap map = new ConfigurableMimeFileTypeMap();

    /**
     * 获取 Content-Type 描述信息
     *
     * @param fileName 文件名称
     * @return
     */
    public static String getContentType(String fileName) {
        return map.getContentType(fileName);
    }
}
