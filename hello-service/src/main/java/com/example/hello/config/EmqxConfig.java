package com.example.hello.config;

import com.example.hello.emqx.impl.CustomMqttCallback;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * EMQ X 配置
 *
 * @author Aaric, created on 2021-06-07T11:05.
 * @version 0.12.0-SNAPSHOT
 */
@Slf4j
@Configuration
public class EmqxConfig {

    @Value("${emqx.server-uri}")
    private String serverUri;

    @Value("${emqx.client.id}")
    private String clientId;

    @Value("${emqx.client.username}")
    private String clientUsername;

    @Value("${emqx.client.password}")
    private String clientPassword;

    @Autowired
    private CustomMqttCallback customMqttCallback;

    @Bean
    MqttClient mqttClient() {
        try {
            MqttClient client = new MqttClient(serverUri, clientId, new MemoryPersistence());
            client.setCallback(customMqttCallback.setMqttClient(client));
            client.connect(mqttConnectOptions());

            return client;

        } catch (MqttException e) {
            log.error("client init exception", e);
            return null;
        }
    }

    @Bean
    MqttConnectOptions mqttConnectOptions() {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setUserName(clientUsername);
        options.setPassword(clientPassword.toCharArray());
        options.setCleanSession(true);
        return options;
    }
}
