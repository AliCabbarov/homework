package org.example.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionEnums {
    PASSWORD_NOT_VALID("Incorrect password"),
    USER_NOT_FOUND("User no found"),
    INVALID_OPTION_EXCEPTION("Invalid option");
    private final String message;
}
