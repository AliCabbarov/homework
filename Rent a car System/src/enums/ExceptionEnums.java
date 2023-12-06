package enums;

import java.time.LocalDateTime;

public enum ExceptionEnums {
    CAR_NOT_FOUND_EXCEPTION("Car not found", LocalDateTime.now()),
    OPERATIONS_NOT_FOUND_EXCEPTION("Operation not found", LocalDateTime.now()),
    INVALID_OPTION_EXCEPTION("Invalid option", LocalDateTime.now());

    private final String message;
    private final LocalDateTime exceptionTime;

    ExceptionEnums(String message, LocalDateTime exceptionTime) {
        this.message = message;
        this.exceptionTime = exceptionTime;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getExceptionTime() {
        return exceptionTime;
    }
}
