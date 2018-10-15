package com.study.adapter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 邮件平台服务
 */
@Slf4j
@Service
public class EmailMessageService implements MessageAdapter {
    @Override
    public void sendMessage(String josn) {
        System.out.println(josn);
        log.info("发送邮件消息成功");
    }
}
