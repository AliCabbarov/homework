package exception;

import enums.ExceptionEnum;

import java.time.LocalDateTime;

public class ApplicationException extends RuntimeException{
    private final String message;
    private final LocalDateTime exceptionTime;
    public ApplicationException(ExceptionEnum e){
        super(e.getMessage());
        this.message = e.getMessage();
        this.exceptionTime = e.getExceptionTime();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public LocalDateTime getExceptionTime() {
        return exceptionTime;
    }
}
