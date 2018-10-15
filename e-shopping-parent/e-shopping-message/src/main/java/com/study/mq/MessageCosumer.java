package com.study.mq;

import com.alibaba.fastjson.JSONObject;
import com.study.adapter.EmailMessageService;
import com.study.adapter.MessageAdapter;
import com.study.constants.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 消费者服务
 */
@Slf4j
@Component
public class MessageCosumer {
    @Autowired
    private MessageAdapter messageAdapter;

    @JmsListener(destination = "${message.destionName}")
    public void reciveQueue(String messageJson) {
        log.info("#####消息服务平台接受消息内容:{}#####", messageJson);
        if (messageJson.isEmpty()) {
            return;
        }
        JSONObject msgJsonObject = JSONObject.parseObject(messageJson);
        JSONObject header = (JSONObject) msgJsonObject.get(Constants.MESSAGE_HEADER);
        if (Constants.INTERFACETYPE_MSG_EMAIL.equals(header.get(Constants.INTERFACETYPE))) {
            messageAdapter =new EmailMessageService();
        }else{
            return ;
        }
        /**
         * 调用第三方接口发送消息
         */
        messageAdapter.sendMessage(messageJson);
    }
}
