package com.example.hello.emqx.impl;

import com.example.hello.core.mqtt.QosEnum;
import com.example.hello.emqx.MqttPublishService;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * MQTT 发布消息服务接口实现
 *
 * @author Aaric, created on 2021-07-07T17:21.
 * @version 0.12.0-SNAPSHOT
 */
@Slf4j
@Component
public class MqttPublishServiceImpl implements MqttPublishService {

    @Autowired
    private MqttClient mqttClient;

    @Override
    public boolean publish(String topic, String payload) {
        return publish(topic, QosEnum.QoS2.value(), payload);
    }

    @Override
    public boolean publish(String topic, int qos, String payload) {
        try {
            mqttClient.publish(topic, payload.getBytes(StandardCharsets.UTF_8), qos, false);
            return true;
        } catch (MqttException e) {
            log.error("publish exception", e);
        }
        return false;
    }
}
