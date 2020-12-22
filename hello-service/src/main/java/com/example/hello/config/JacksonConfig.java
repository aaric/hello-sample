package com.example.hello.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Jackson配置
 *
 * @author Aaric, created on 2020-12-22T16:50.
 * @version 0.4.0-SNAPSHOT
 */
@Configuration
public class JacksonConfig {

    @Bean
    ObjectMapper customObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);
        return objectMapper;
    }

//    @Bean
//    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() throws Exception {
//        // https://www.baeldung.com/spring-boot-formatting-json-dates
//        return builder -> {
//            builder.serializerByType(Date.class, new WriteDateAsSecondsDateSerializer());
//            builder.deserializerByType(Date.class, new WriteDateAsSecondsDeserializer());
//        };
//    }
}
