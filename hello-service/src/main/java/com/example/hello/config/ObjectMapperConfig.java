package com.example.hello.config;

import com.example.hello.json.jackson.WriteDateAsSecondsDeserializer;
import com.example.hello.json.jackson.WriteDateAsSecondsSerializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * ObjectMapper配置
 *
 * @author Aaric, created on 2020-12-22T16:50.
 * @version 0.4.0-SNAPSHOT
 */
@Configuration
public class ObjectMapperConfig {

    @Bean
    ObjectMapper customObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);

        // 标准日期与秒时间戳相互转换，设置全局序列化器与反序列化器
        SimpleModule customDateModule = new SimpleModule();
        customDateModule.addSerializer(Date.class, new WriteDateAsSecondsSerializer());
        customDateModule.addDeserializer(Date.class, new WriteDateAsSecondsDeserializer());
        objectMapper.registerModule(customDateModule);

        return objectMapper;
    }
}
