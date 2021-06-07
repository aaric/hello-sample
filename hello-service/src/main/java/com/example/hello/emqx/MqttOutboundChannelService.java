package com.example.hello.emqx;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;

/**
 * MQTT 消息服务接口
 *
 * @author Aaric, created on 2021-06-07T11:30.
 * @version 0.11.0-SNAPSHOT
 */
@MessagingGateway(defaultRequestChannel = "mqttOutboundChannel")
public interface MqttOutboundChannelService {

    /**
     * 发送消息
     *
     * @param data  数据
     * @param topic 主题
     */
    void send(String data, @Header(MqttHeaders.TOPIC) String topic);
}
