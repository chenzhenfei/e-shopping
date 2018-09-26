package com.study.base;

import com.study.constants.ResponseConstants;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;

@Component
public class ResponseBaseService {

    //返回成功，返回数据data
    public  ResponseBase setResultSuccess(Object data){
        return setResult(ResponseConstants.RTNCODE_CODE_2OO,ResponseConstants.RTNCODE_MSG_2OO,data);
    }
    //返回成功，不返回数据data
    public  ResponseBase setResultSuccess(){
        return setResultSuccess(null);
    }
    //返回失败 返回信息
    public  ResponseBase setResultError(String msg){
        return setResult(ResponseConstants.RTNCODE_CODE_500,msg,null);
    }
    public  ResponseBase setResultError(){
        return setResultError(null);
    }
    /**
     * 通用返回封装
     * @param rtnCode
     * @param rtnMsg
     * @param data
     * @return
     */
    public ResponseBase setResult(String rtnCode,String rtnMsg,Object data){
        return new ResponseBase(rtnCode,rtnMsg,data);
    }
}
