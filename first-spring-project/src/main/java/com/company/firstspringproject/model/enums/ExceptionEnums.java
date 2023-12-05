package com.company.firstspringproject.model.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
public enum ExceptionEnums {
    USER_NOT_FOUND_EXCEPTION("user not found", HttpStatus.NOT_FOUND, LocalDateTime.now());
    private final String status;
    private final HttpStatus httpStatus;
    private final LocalDateTime localDateTime;

    ExceptionEnums(String status, HttpStatus httpStatus,LocalDateTime localDateTime) {
        this.status = status;
        this.httpStatus = httpStatus;
        this.localDateTime = localDateTime;
    }
}
