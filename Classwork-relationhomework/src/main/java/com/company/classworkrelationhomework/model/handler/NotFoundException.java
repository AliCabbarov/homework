package com.company.classworkrelationhomework.model.handler;

import com.company.classworkrelationhomework.model.enums.ErrorCode;
import lombok.Getter;

@Getter
public class NotFoundException extends ApplicationException{
    private final ErrorCode errorCode;
    private final String[] args;
    public NotFoundException(ErrorCode errorCode,String ... args) {
        super(errorCode,args);
        this.errorCode = errorCode;
        this.args = args;
    }
}
