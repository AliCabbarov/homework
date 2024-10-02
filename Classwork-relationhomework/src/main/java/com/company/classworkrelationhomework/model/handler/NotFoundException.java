package com.company.classworkrelationhomework.model.handler;

import lombok.Getter;

@Getter
public class NotFoundException extends ApplicationException{
    private final String notFoundedData;
    public NotFoundException(String message,Object notFoundedData) {
        super(message);
        this.notFoundedData = notFoundedData.toString();
    }
}
