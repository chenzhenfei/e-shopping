package com.study.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.jms.Queue;

/**
 * mq 配置文件
 */
public class MqConfig {
    @Value("${destionName}")
    private String destionName;

    @Bean
    private Queue  queue(){
        return new ActiveMQQueue(this.destionName);
    }

}
