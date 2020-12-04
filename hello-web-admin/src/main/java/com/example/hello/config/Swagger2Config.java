package com.example.hello.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
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

import java.net.InetAddress;
import java.text.MessageFormat;

/**
 * Swagger2配置
 *
 * @author Aaric, created on 2020-12-03T18:05.
 * @version 0.1.0-SNAPSHOT
 */
@EnableSwagger2
@Configuration
public class Swagger2Config implements InitializingBean {

    @Value("localhost")
    private String serverHost;

    @Value("${server.port}")
    private String serverPort;

    @Bean
    Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .host(serverHost)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example"))
                .paths(PathSelectors.any())
                .build();
    }

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("在线API文档")
                .description("Spring Boot 2.3.x框架集成测试")
                .termsOfServiceUrl(MessageFormat.format("http://{0}:{1}/doc.html", serverHost, serverPort))
                .contact(new Contact("Aaric", "", "vipaaric@gmail.com"))
                .version("0.1.0")
                .build();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        serverHost = InetAddress.getLocalHost().getHostAddress();
    }
}
