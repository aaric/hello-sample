package com.example.hello.config;

import com.example.hello.web.ws.WebSocketEndPoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;

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

    @Scheduled(cron = "*/1 * * * * ?")
    void sentWsMsg() {
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
    }
}
