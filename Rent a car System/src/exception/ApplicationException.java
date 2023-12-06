package exception;

import enums.ExceptionEnums;

import java.time.LocalDateTime;

public class ApplicationException extends RuntimeException{
    private final String message;
    private final LocalDateTime exceptionTime;

    public ApplicationException(ExceptionEnums exceptionEnums) {
        super(exceptionEnums.getMessage());
        this.message = exceptionEnums.getMessage();
        this.exceptionTime = exceptionEnums.getExceptionTime();
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getExceptionTime() {
        return exceptionTime;
    }
}
