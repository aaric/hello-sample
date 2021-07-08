package com.example.hello.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Quartz配置
 *
 * @author Aaric, created on 2021-06-16T16:07.
 * @version 0.11.0-SNAPSHOT
 */
@Slf4j
@Configuration
@EnableScheduling
public class QuartzConfig {

    //@Scheduled(cron = "*/1 * * * * ?")
    /*void sentWsMsg() {
        WebSocketEndPoint.WEBSOCKET_SESSIONS.forEach((id, session) -> {
            if (session.isOpen()) {
                try {
                    session.getBasicRemote()
                            .sendText("hello world");
                } catch (IOException e) {
                    log.error("");
                }
            }
        });
    }*/
}
