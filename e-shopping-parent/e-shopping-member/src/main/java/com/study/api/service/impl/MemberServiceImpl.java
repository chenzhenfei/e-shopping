package com.study.api.service.impl;

import com.study.activemq.ProducerService;
import com.study.api.entity.MemberEntity;
import com.study.api.service.MemberService;
import com.study.base.ResponseBase;
import com.study.base.ResponseBaseService;
import com.study.dao.mybatis.MemberMapper;
import com.study.utils.MD5Utils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


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
        // 发送消息到消息中间件
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

    public void sendMsg(String json){
        producer.sendMsg(json);  //
    }

}
