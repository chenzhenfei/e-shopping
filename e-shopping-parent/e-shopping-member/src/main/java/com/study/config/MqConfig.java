package com.study.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

/**
 * mq 配置文件
 */
@Configuration
public class MqConfig {
    @Value("${message.destionName}")
    private String destionName;

    @Bean
    public Queue  queue(){
        return new ActiveMQQueue(this.destionName);
    }

}
