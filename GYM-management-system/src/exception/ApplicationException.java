package exception;

import enums.Exception;

import java.time.LocalDateTime;

public class ApplicationException extends RuntimeException{
    private final String message;
    private final LocalDateTime exceptionTime;

    public ApplicationException(Exception exception) {
        super(exception.getMessage());
        this.message = exception.getMessage();
        this.exceptionTime = exception.getExceptionTime();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public LocalDateTime getExceptionTime() {
        return exceptionTime;
    }
}
