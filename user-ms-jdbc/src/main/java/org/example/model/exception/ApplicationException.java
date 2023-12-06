package org.example.model.exception;

import lombok.Getter;
import org.example.model.enums.ExceptionEnums;

@Getter
public class ApplicationException extends RuntimeException{
    private final String message;

    public ApplicationException(ExceptionEnums e) {
        this.message = e.getMessage();
    }
}
