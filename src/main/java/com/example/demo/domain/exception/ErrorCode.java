package com.example.demo.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "NOT_FOUND", "USER NOT FOUND"),
    DUPL_EMAIL(HttpStatus.BAD_REQUEST, "BAD_REQUEST", "DUPLICATED EMAIL");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
    }