package com.company.classworkrelationhomework.model.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public enum ErrorCode {
    NOT_FOUND("exception.not.found","exception.not.found.detail", HttpStatus.NOT_FOUND),
    ALREADY_EXIST("exception.already.exist","exception.already.exist.detail", HttpStatus.BAD_REQUEST);
    private final String code;
    private final String detailCode;
    private final HttpStatus status;

    ErrorCode(String code, String detailCode, HttpStatus status) {
        this.code = code;
        this.detailCode = detailCode;
        this.status = status;
    }
}
