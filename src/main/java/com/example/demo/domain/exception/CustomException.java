package com.example.demo.domain.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException{
    private final HttpStatus httpStatus;
    private final String code;
    private final String msg;


    public CustomException(HttpStatus httpStatus, String code, String msg) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getCode() {
        return code;
    }
}
