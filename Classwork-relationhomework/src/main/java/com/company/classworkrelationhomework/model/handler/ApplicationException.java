package com.company.classworkrelationhomework.model.handler;

import com.company.classworkrelationhomework.model.enums.ErrorCode;
import lombok.Getter;

@Getter
public class ApplicationException extends RuntimeException {
    private final ErrorCode errorCode;
    private final String[] args;
    public ApplicationException(ErrorCode errorCode,String ... args) {
        this.errorCode = errorCode;
        this.args = args;
    }
}
