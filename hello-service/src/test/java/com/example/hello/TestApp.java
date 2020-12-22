package com.example.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring boot test launcher.
 *
 * @author Aaric, created on 2020-12-22T15:48.
 * @version 0.1.0-SNAPSHOT
 */
@SpringBootApplication
public class TestApp {

    /**
     * main
     *
     * @param args custom inputs
     */
    public static void main(String[] args) {
        SpringApplication.run(TestApp.class, args);
    }
}
