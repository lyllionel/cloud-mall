package com.lionel.mall.common.exception;

/**
 * 自定义全局异常 业务类
 */
public class ServiceException extends RuntimeException {

    protected Integer code;

    ServiceException(String message) {
        super(message);
    }

    ServiceException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
