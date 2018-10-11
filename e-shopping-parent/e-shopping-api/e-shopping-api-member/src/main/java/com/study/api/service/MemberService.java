package com.study.api.service;

import com.study.api.entity.MemberEntity;
import com.study.base.ResponseBase;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.awt.*;

@RequestMapping("/member")
public interface MemberService {
    @RequestMapping("/findById")
    ResponseBase findById(@RequestParam("userId") long userId);

    @RequestMapping(value = "/regUser" )
    ResponseBase regUser( MemberEntity emberEntity);
}
