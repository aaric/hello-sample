package com.example.hello.emqx.impl;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Service;

/**
 * MQTT 消息服务回调接口实现
 *
 * @author Aaric, created on 2021-06-07T13:37.
 * @version 0.11.0-SNAPSHOT
 */
@Slf4j
@Service
public class MqttChannelCallbackImpl implements MqttCallback {

    @Override
    public void connectionLost(Throwable cause) {
        log.error("connectionLost exception", cause);
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        log.info("messageArrived: topic={}, qos: {}, payload: {}", topic, message.getQos(), message.getPayload());
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        log.info("deliveryComplete: token={}", token);
    }
}
