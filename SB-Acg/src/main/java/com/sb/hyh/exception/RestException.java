package com.sb.hyh.exception;


import com.sb.hyh.vo.Response;

/**
 * REST服务异常,发生在REST接口调用异常时
 */
public class RestException extends RuntimeException {
    /**
     * 错误码
     */
    private int code;

    public RestException() {
        super();
        code = Response.CODE_SERVER_ERROR;
    }

    public RestException(int code) {
        super();
        this.code = code;
    }

    public RestException(String message) {
        super(message);
        code = Response.CODE_SERVER_ERROR;
    }

    public RestException(int code, String message) {
        super(message);
        this.code = code;
    }

    public RestException(String message, Throwable cause) {
        super(message, cause);
    }

    public RestException(Throwable cause) {
        super(cause);
    }

    public RestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public int getCode() {
        return code;
    }
}
