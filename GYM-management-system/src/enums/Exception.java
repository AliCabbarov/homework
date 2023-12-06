package enums;

import java.time.LocalDateTime;

public enum Exception {
    NOT_FOUND_EXCEPTION("Not found", LocalDateTime.now()), WRONG_FORMAT_EXCEPTION("Wrong format", LocalDateTime.now()),
    INVALID_OPTION_EXCEPTION("Invalid option",LocalDateTime.now());
    private final String message;
    private final LocalDateTime exceptionTime;

    Exception(String message, LocalDateTime exceptionTime) {
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
