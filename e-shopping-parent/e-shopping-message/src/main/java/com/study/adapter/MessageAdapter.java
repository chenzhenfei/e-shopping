package com.study.adapter;

import com.alibaba.fastjson.JSONObject;

/**
 * 消息适配器
 */
public interface MessageAdapter {
    public void sendMessage(JSONObject josn);
}
