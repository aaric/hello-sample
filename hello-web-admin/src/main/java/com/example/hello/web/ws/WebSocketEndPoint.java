package com.example.hello.web.ws;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * WebSocket测试程序
 *
 * @author Aaric, created on 2021-06-16T15:13.
 * @version 0.11.0-SNAPSHOT
 */
@Slf4j
@Component
@ServerEndpoint("/ws/test/{ts}")
public class WebSocketEndPoint {

    @OnOpen
    public void onOpen(Session session,
                       @PathParam("ts") String ts) {
        log.info("onOpen: sessionId={}, ts={}", session.getId(), ts);
    }

    @OnMessage
    public void onMessage(Session session,
                          String message,
                          @PathParam("ts") String ts) {
        log.info("onMessage: sessionId={}, message={}, ts={}", session.getId(), message, ts);
    }

    @OnClose
    public void onClose(Session session, @PathParam("ts") String ts) {
        try {
            session.close();
        } catch (IOException e) {
            log.error("onClose exception", e);
        } finally {
            log.info("onClose: sessionId={}, ts={}", session.getId(), ts);
        }
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        try {
            session.close();
        } catch (IOException e) {
            log.error("onError exception", e);
        } finally {
            log.info("onError: sessionId={}", session.getId());
        }
    }
}
