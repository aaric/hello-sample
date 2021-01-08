package com.example.hello.config;

import com.example.hello.json.spring.DateAsSecondsConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.format.FormatterRegistry;

/**
 * SpringMvc转换器配置（不建议开启，推荐DateAsSecondsFormatter，更强大）
 *
 * @author Aaric, created on 2021-01-08T17:26.
 * @version 0.4.0-SNAPSHOT
 * @see WebMvcConfig#addFormatters(FormatterRegistry)
 */
//@Configuration
public class WebMvcConverterConfig {

    @Bean
    DateAsSecondsConverter dateAsSecondsConverter() {
        return new DateAsSecondsConverter();
    }
}
