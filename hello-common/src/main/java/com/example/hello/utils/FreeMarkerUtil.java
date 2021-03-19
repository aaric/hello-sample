package com.example.hello.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;

/**
 * 模板工具类
 *
 * @author Aaric, created on 2021-03-19T12:14.
 * @version 0.9.1-SNAPSHOT
 */
public final class FreeMarkerUtil {

    /**
     * 配置版本
     */
    private static final Configuration CFG = new Configuration(Configuration.VERSION_2_3_30);

    static {
        /**
         * 设置模板工作目录
         */
        CFG.setClassLoaderForTemplateLoading(ClassLoader.getSystemClassLoader(), "/flts");
    }

    /**
     * 创建模板字符流
     *
     * @param templateFileName 模板文件名称
     * @param model            模型对象
     * @return
     * @throws Exception
     */
    public static String process2String(String templateFileName, Object model) throws Exception {
        Template template = CFG.getTemplate(templateFileName);
        StringWriter result = new StringWriter();
        template.process(model, result);
        return result.toString();
    }
}
