package com.company.exception;

import com.company.enums.ExceptionEnum;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ApplicationException extends RuntimeException{
    private final String message;
    private final LocalDateTime exceptionTime;
    public ApplicationException(ExceptionEnum e){
        super(e.getMessage());
        this.message = e.getMessage();
        this.exceptionTime = e.getExceptionTime();
    }
}
