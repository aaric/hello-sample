package com.example.hello;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring boot launcher.
 *
 * @author Aaric, created on 2020-12-03T17:53.
 * @version 0.1.0-SNAPSHOT
 */
@Slf4j
@SpringBootApplication
public class App {

    /**
     * main
     *
     * @param args custom inputs
     */
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
