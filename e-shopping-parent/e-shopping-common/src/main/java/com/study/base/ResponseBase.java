package com.study.base;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class ResponseBase {
    /**
     *  响应状态吗
     */
    private String rtnCode;
    /**
     * 响应信息
     */
    private String rtnMsg;
    /**
     * 响应数据
     *
     */
    private Object data;

    public ResponseBase(String rtnCode, String rtnMsg, Object data) {
        super();
        this.rtnCode = rtnCode;
        this.rtnMsg = rtnMsg;
        this.data = data;
    }

    public ResponseBase() {
    }

}
