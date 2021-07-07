package com.example.hello.core.mqtt;

/**
 * MQTT Qos 常量
 *
 * @author Aaric, created on 2021-07-07T15:10.
 * @version 0.12.0-SNAPSHOT
 */
public enum QosEnum {

    QoS0(0), QoS1(1), QoS2(2);

    private final int value;

    QosEnum(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
