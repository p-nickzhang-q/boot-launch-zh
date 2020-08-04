package com.zh.boot.launch.config.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class WebExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> customerException(CustomException e, WebRequest request) {
        if (e.getCode() == CustomExceptionType.SYSTEM_ERROR.getCode()) {
            //400异常不需要持久化，将异常信息以友好的方式告知用户就可以
            //TODO 将500异常信息持久化处理，方便运维人员处理
        }
        return handleExceptionInternal(e, AjaxResponse.error(e), new HttpHeaders(), HttpStatus.valueOf(e.getCode()), request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        FieldError fieldError = ex.getBindingResult().getFieldError();
        assert fieldError != null;
        AjaxResponse response = AjaxResponse.error(new CustomException(CustomExceptionType.USER_INPUT_ERROR, fieldError.getDefaultMessage()));
        return handleExceptionInternal(ex, response, new HttpHeaders(), HttpStatus.valueOf(400), request);
    }

    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        FieldError fieldError = ex.getBindingResult().getFieldError();
        assert fieldError != null;
        AjaxResponse response = AjaxResponse.error(new CustomException(CustomExceptionType.USER_INPUT_ERROR, fieldError.getDefaultMessage()));
        return handleExceptionInternal(ex, response, new HttpHeaders(), HttpStatus.valueOf(400), request);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> exception(Exception e, WebRequest request) {
        //TODO 将异常信息持久化处理，方便运维人员处理

        //没有被程序员发现，并转换为CustomException的异常，都是其他异常或者未知异常.
        AjaxResponse error = AjaxResponse.error(new CustomException(CustomExceptionType.OTHER_ERROR, "未知异常"));
        return handleExceptionInternal(e, error, new HttpHeaders(), HttpStatus.valueOf(500), request);

    }


}
