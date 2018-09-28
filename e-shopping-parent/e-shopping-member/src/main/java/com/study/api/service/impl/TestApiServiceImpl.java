package com.study.api.service.impl;


import com.study.api.service.TestApiService;
import com.study.base.BaseRedisService;
import com.study.base.ResponseBase;
import com.study.base.ResponseBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TestApiServiceImpl implements TestApiService {
    @Resource
    private BaseRedisService baseRedisService;


    @Resource
    private ResponseBaseService responseBaseService;
    /**
     *
     * @param id
     * @param name
     * @return 统一返回格式（http+json）,统一的规范格式
     * { 'rtnCode' :""
     *   'rtnMsg' :""
     *   'data': Object
     * }
     */
    @Override
    public Map<String, Object> test(Integer id, String name) {
        Map<String ,Object> result =new HashMap<String,Object>();
        result.put("rtnCode","200");
        result.put("rtnMsg","success");
        result.put("data", "id:"+id+",name"+name);
        return result;
    }

    @Override
    public ResponseBase testResponseBase() {
        return responseBaseService.setResultSuccess();
}


    @Override
    public ResponseBase testRedis(String key, String value) {
        baseRedisService.set(key,value);
        return responseBaseService.setResultSuccess();
    }

    @Override
    public ResponseBase  getRedis(String key) {
        String result=(String) baseRedisService.get(key);
        return responseBaseService.setResultSuccess(result);
    }

}
