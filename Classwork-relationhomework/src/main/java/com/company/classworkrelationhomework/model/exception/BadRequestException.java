package com.company.classworkrelationhomework.model.exception;

import com.company.classworkrelationhomework.model.enums.ErrorCode;
import lombok.Getter;

@Getter
public class BadRequestException extends ApplicationException{
    public BadRequestException(ErrorCode errorCode, String... args) {
        super(errorCode, args);
    }
}
