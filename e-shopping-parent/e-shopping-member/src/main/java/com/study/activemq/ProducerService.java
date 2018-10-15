package com.study.activemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;
import javax.jms.Queue;

/**
 * 生产者
 */
@Component
public class ProducerService {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    public void sendMsg(String msg){
        this.jmsMessagingTemplate.convertAndSend(queue,msg);
    }

}
