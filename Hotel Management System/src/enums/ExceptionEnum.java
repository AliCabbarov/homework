package enums;

import java.time.LocalDateTime;

public enum ExceptionEnum {
    CUSTOMER_NOT_FOUND_EXCEPTION("Customer not found", LocalDateTime.now()),
    ROOM_NOT_FOUND("Room not found", LocalDateTime.now()),
    RESERVATION_NOT_FOUND("Reservation not found", LocalDateTime.now()),
    NULL_VALUE_EXCEPTION("Null value", LocalDateTime.now()),
    NULL_CUSTOMER_EXCEPTION("Null Customer", LocalDateTime.now()),
    IRREVOCABLE_EXCEPTION("Irrevocable", LocalDateTime.now()),
    HAVE_RESERVATION_EXCEPTION("Have reservation", LocalDateTime.now()),
    INVALID_OPTION_EXCEPTION("Invalid option", LocalDateTime.now()),
    LOW_PRICE_EXCEPTION("Low price", LocalDateTime.now()),
    LOW_AGE_EXCEPTION("Low age", LocalDateTime.now()),
    SAME_EMAIL_EXCEPTION("Same email", LocalDateTime.now()),
    LOW_MONEY_EXCEPTION("Low money", LocalDateTime.now());
    private final String message;
    private final LocalDateTime exceptionTime;

    ExceptionEnum(String message, LocalDateTime exceptionTime) {
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
