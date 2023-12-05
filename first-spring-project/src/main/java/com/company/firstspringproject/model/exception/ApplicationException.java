package com.company.firstspringproject.model.exception;

import com.company.firstspringproject.model.enums.ExceptionEnums;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
public class ApplicationException extends RuntimeException {
    private final String status;
    private final HttpStatus httpStatus;
    private final LocalDateTime localDateTime;

    public ApplicationException(ExceptionEnums exception) {
        super(exception.getStatus());
        this.status = exception.getStatus();
        this.httpStatus = exception.getHttpStatus();
        this.localDateTime = exception.getLocalDateTime();
    }
}
