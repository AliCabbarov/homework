package com.company.classworkrelationhomework.model.handler;

import lombok.Getter;

@Getter
public class ApplicationException extends RuntimeException {
    private final String message;
    public ApplicationException(String message) {
        super(message);
        this.message = message;
    }
}
