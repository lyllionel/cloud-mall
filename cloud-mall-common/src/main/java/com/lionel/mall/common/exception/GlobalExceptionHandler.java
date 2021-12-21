package com.lionel.mall.common.exception;

/**
 * 全局异常处理
 * IllegalArgumentException MethodArgumentConversionNotSupportedException MethodArgumentTypeMismatchException
 * HttpMediaTypeNotAcceptableException MissingServletRequestParameterException NoHandlerFoundException
 * HttpRequestMethodNotSupportedException HttpMessageNotWritableException HttpMessageNotReadableException
 * MethodArgumentNotValidException
 *
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentConversionNotSupportedException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public void serviceException(ServiceException ex) {
        LOGGER.error("内部业务异常 {}", ex);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public void illegalArgumentException(IllegalArgumentException ex) {
        LOGGER.error("无效的参数 {}", ex);
    }

    @ExceptionHandler(MethodArgumentConversionNotSupportedException.class)
    @ResponseBody
    public void methodArgumentConversionNotSupportedException(MethodArgumentConversionNotSupportedException ex) {
        LOGGER.error("不支持的方法参数转换 {}", ex);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseBody
    public void methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        LOGGER.error("方法参数类型不匹配 {}", ex);
    }

    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    @ResponseBody
    public void httpMediaTypeNotAcceptableException(HttpMediaTypeNotAcceptableException ex) {
        LOGGER.error("不支持的HTTP MediaType {}", ex);
    }


    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    public void missingServletRequestParameterException(MissingServletRequestParameterException ex) {
        LOGGER.error("缺少请求参数 {}", ex);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void noHandlerFoundException(NoHandlerFoundException ex) {
        LOGGER.error("Not found {}", ex);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public void httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
        LOGGER.error("不支持的Http请求方法 {}", ex);
    }

    @ExceptionHandler(HttpMessageNotWritableException.class)
    @ResponseBody
    public void HttpMessageNotWritableException(HttpMessageNotWritableException ex) {
        LOGGER.error("HttpMessageNotWritableException {}", ex);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public void HttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        LOGGER.error("HttpMessageNotReadableException {}", ex);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public void methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        LOGGER.error("参数校验未通过 {}", ex);
    }

}
