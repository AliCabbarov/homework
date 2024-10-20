package com.company.classworkrelationhomework.model.exception;

import com.company.classworkrelationhomework.model.dto.exception.ExceptionResponse;
import com.company.classworkrelationhomework.model.enums.ErrorCode;
import lombok.Getter;

@Getter
public class UsernameNotFoundException extends ApplicationException {


    public UsernameNotFoundException(ErrorCode errorCode, String... args) {
        super(errorCode, args);
    }

}
