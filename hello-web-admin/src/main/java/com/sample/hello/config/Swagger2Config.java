package com.sample.hello.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2配置
 *
 * @author Aaric, created on 2020-12-03T18:05.
 * @version 0.1.0-SNAPSHOT
 */
@EnableSwagger2
@Configuration
public class Swagger2Config {

    @Bean
    Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example"))
                .paths(PathSelectors.any())
                .build();
    }

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("在线API文档")
                .description("仅测试最新spring boot集成。")
                .termsOfServiceUrl("http://localhost:8080")
                .contact(new Contact("Aaric", "", "vipaaric@gmail.com"))
                .version("0.1.0")
                .build();
    }
}
