package com.example.hello.emqx.impl;

import com.example.hello.core.mqtt.QosEnum;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 自定义消息回调接口实现
 *
 * @author Aaric, created on 2021-07-07T16:13.
 * @version 0.12.0-SNAPSHOT
 */
@Slf4j
@Component
public class CustomMqttCallback implements MqttCallbackExtended {

    @Value("${mqtt.subscribe.topic}")
    private String subscribeTopic;

    private MqttClient mqttClient;

    public CustomMqttCallback setMqttClient(MqttClient mqttClient) {
        this.mqttClient = mqttClient;
        return this;
    }

    @Override
    public void connectComplete(boolean reconnect, String serverURI) {
        try {
            mqttClient.subscribe(subscribeTopic, QosEnum.QoS2.value());
        } catch (MqttException e) {
            log.error("subscribe exception", e);
        }
        log.info("connect complete...");
    }

    @Override
    public void connectionLost(Throwable cause) {
        log.error("connect lost...", cause);
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        log.info("{} -> {}, {}, \n{}", topic, message.getId(), message.getQos(), new String(message.getPayload()));
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        log.info("delivery complete...");
    }
}
