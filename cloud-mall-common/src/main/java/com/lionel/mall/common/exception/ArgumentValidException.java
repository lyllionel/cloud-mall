package com.lionel.mall.common.exception;

/**
 * 参数校验异常
 *
 */
public class ArgumentValidException extends ServiceException {

    ArgumentValidException(String message) {
        super(message);
    }

}
