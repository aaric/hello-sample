package com.example.hello.config;

import com.example.hello.json.spring.DateAsSecondsFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebMvc配置
 *
 * @author Aaric, created on 2021-01-08T17:26.
 * @version 0.4.0-SNAPSHOT
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DateAsSecondsFormatter());
    }
}
