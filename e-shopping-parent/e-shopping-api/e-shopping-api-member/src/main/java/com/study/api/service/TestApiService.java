package com.study.api.service;


import com.study.base.ResponseBase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * api 对外接口层， 后期会继承cxf jax-rs 实现rest 方式接口调用
 */
@RequestMapping("/member")
@Api(value = "会员服务接口",description = "会员服务接口")
@Path("/member")
public interface TestApiService {
    /**
     *  consumes： 指定处理请求的提交内容类型（Content-Type），例如application/json, text/html;
     * produces: 指定返回的内容类型，仅当request请求头中的(Accept)类型中包含该指定类型才返回；
     * @param id
     * @param name
     * @return
     */
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @Path("/test")
    @ApiOperation(value = "测试接口",notes = "测试接口",response = Map.class)
    @Produces(value=MediaType.APPLICATION_JSON) /**處理相應類型**/
    @Consumes(value = MediaType.TEXT_PLAIN)
    public Map<String,Object> test(@ApiParam(value = "会员id") Integer id, @ApiParam("会员名称") String name);

    @RequestMapping(value = "/testResponseBase",method = RequestMethod.GET)
    @Path("/testResponseBase")
    @ApiOperation(value = "测试接口统一响应定义",notes = "测试接口统一响应定义",response = ResponseBase.class)
    @Produces(value=MediaType.APPLICATION_JSON) /**處理相應類型**/
    @Consumes(value = MediaType.TEXT_PLAIN)
    public ResponseBase testResponseBase();
}
