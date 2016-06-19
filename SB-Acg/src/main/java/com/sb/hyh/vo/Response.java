package com.sb.hyh.vo;

/**
 * Rest返回对象
 */
public class Response {
    /**
     * 成功
     */
    public static final int CODE_SUCCESS = 200;
    /**
     * 错误的请求
     */
    public static final int BAD_REQUEST = 400;
    /**
     * 服务器错误
     */
    public static final int CODE_SERVER_ERROR = 500;

    /**
     * 响应码
     */
    private int code;
    /**
     * 返回消息
     */
    private String msg;
    /**
     * 数据
     */
    private Object data;

    public Response() {
        this.code = CODE_SUCCESS;
        this.msg = "操作成功";
    }

    public Response(String msg) {
        this.code = CODE_SUCCESS;
        this.msg = msg;
    }

    public Response(Object data) {
        this.code = CODE_SUCCESS;
        this.msg = "操作成功";
        this.data = data;
    }

    public Response(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public Response(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
