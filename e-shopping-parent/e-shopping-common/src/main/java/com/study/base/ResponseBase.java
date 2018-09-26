package com.study.base;

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

    public String getRtnCode() {
        return rtnCode;
    }

    public void setRtnCode(String rtnCode) {
        this.rtnCode = rtnCode;
    }

    public String getRtnMsg() {
        return rtnMsg;
    }

    public void setRtnMsg(String rtnMsg) {
        this.rtnMsg = rtnMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResponseBase(String rtnCode, String rtnMsg, Object data) {
        super();
        this.rtnCode = rtnCode;
        this.rtnMsg = rtnMsg;
        this.data = data;
    }

    public ResponseBase() {
    }

}
