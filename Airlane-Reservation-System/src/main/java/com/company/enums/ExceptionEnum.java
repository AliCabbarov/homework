package com.company.enums;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public enum ExceptionEnum {
    ALREADY_EXIST_EXCEPTION("Already exist", LocalDateTime.now()),
    INVALID_OPTION_EXCEPTION("Invalid option", LocalDateTime.now()),
    YOU_HAVE_NOT_BOOK_EXCEPTION("You have not book", LocalDateTime.now()),
    WRONG_USERNAME_OR_PASSWORD_EXCEPTION("Wrong username or password", LocalDateTime.now()),
    YOU_HAVE_NOT_ORDER_EXCEPTION("You have not order", LocalDateTime.now()),
    IRREVOCABLE_EXCEPTION("Irrevocable", LocalDateTime.now()),
    FLIGHTS_NOT_FOUND_EXCEPTION("Flight not found", LocalDateTime.now()),
    PASSENGER_NOT_FOUND("Passenger not found", LocalDateTime.now()),
    TICKETS_NOT_FOUND("Ticket not found", LocalDateTime.now());
    private final String message;
    private final LocalDateTime exceptionTime;

    ExceptionEnum(String message, LocalDateTime exceptionTime) {
        this.message = message;
        this.exceptionTime = exceptionTime;
    }

}
