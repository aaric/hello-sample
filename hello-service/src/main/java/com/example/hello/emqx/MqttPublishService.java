package com.example.hello.emqx;

/**
 * MQTT 发布消息服务接口
 *
 * @author Aaric, created on 2021-07-07T17:18.
 * @version 0.12.0-SNAPSHOT
 */
public interface MqttPublishService {

    boolean publish(String topic, String payload);

    boolean publish(String topic, int qos, String payload);
}
