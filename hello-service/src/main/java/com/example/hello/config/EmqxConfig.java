package com.example.hello.config;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

/**
 * EMQ X 配置
 *
 * @author Aaric, created on 2021-06-07T11:05.
 * @version 0.11.0-SNAPSHOT
 */
@Configuration
public class EmqxConfig {

    @Bean
    MqttConnectOptions mqttConnectOptions() {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setUserName("admin");
        options.setPassword("public".toCharArray());
        options.setServerURIs(new String[]{"tcp://10.0.11.32:1883"});
        options.setKeepAliveInterval(2);
        return options;
    }

    @Bean
    DefaultMqttPahoClientFactory mqttClientFactory() {
        DefaultMqttPahoClientFactory clientFactory = new DefaultMqttPahoClientFactory();
        clientFactory.setConnectionOptions(mqttConnectOptions());
        return clientFactory;
    }

    MessageChannel mqttOutboundChannel() {
        return new DirectChannel();
    }

    @Bean
    @ServiceActivator(inputChannel = "mqttOutboundChannel")
    MessageHandler messageHandler() {
        MqttPahoMessageHandler messageHandler = new MqttPahoMessageHandler("mymqttid", mqttClientFactory());
        messageHandler.setAsync(true);
        messageHandler.setDefaultTopic("mytopic");
        return messageHandler;
    }
}
