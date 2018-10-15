package com.study.api.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.study.activemq.ProducerService;
import com.study.api.entity.MemberEntity;
import com.study.api.service.MemberService;
import com.study.base.ResponseBase;
import com.study.base.ResponseBaseService;
import com.study.constants.Constants;
import com.study.dao.mybatis.MemberMapper;
import com.study.utils.MD5Utils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@Slf4j
@RestController
public class MemberServiceImpl implements MemberService {
    @Autowired
    private ProducerService producer;
    @Resource
    private MemberMapper memberMapper;
    @Resource
    private ResponseBaseService responseBaseService;

    @Override
    public ResponseBase regUser(@RequestBody MemberEntity emberEntity) {
        //参数验证
        if (StringUtils.isEmpty(emberEntity.getPassword())) {
            return responseBaseService.setResultError("密码不能为空");
        }
        //密码加密
        emberEntity.setPassword(MD5Utils.MD5(emberEntity.getPassword()));
        Integer result = memberMapper.insertUser(emberEntity);
        if (result <= 0) {
            return responseBaseService.setResultError("用户注册失败");
        }
        // 发送注册邮件消息到消息中间件
        log.info("用户注册发送邮件");
        producer.sendMsg(messageToJson(Constants.INTERFACETYPE_MSG_EMAIL,emberEntity.getEmail()));
        return responseBaseService.setResultSuccess("用户注册成功");
    }

    @Override
    public ResponseBase findById(long userId) {
        MemberEntity user = memberMapper.findById(userId);
        if (user == null) {
            return responseBaseService.setResultError("未找到用户");
        }
        return responseBaseService.setResultSuccess(user);
    }

    /**
     * 根据消息类型和消息分装消息报文，一般为消息头和消息体
     * @param interType
     * @param message
     * @return
     */

    /**
     *  mq 协议接口规定
     *  {
     *     "header": {
     *         "interfaceType": "接口类型"
     *     },
     *     "content": {}
     * }
     */
    public String messageToJson(String interType,String message){
        JSONObject root =new JSONObject();
        JSONObject header =new JSONObject();
        JSONObject content =new JSONObject();
        header.put(Constants.INTERFACETYPE,interType);
        content.put(Constants.INTERFACETYPE_MSG_EMAIL,message);
        root.put(Constants.MESSAGE_HEADER,header);
        root.put(Constants.MESSAGE_CONTENT,content);
        return root.toJSONString();
    }




}
