package com.company.demo.model.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferDto {
    private final static String NOT_NULL = "exception.not-null";
    private final static String NOT_BLANK = "exception.not-blank";
    public final static String NOT_FOUND = "exception.not_found";
    @AssertTrue(message = "exception.assert_true")
    private boolean termCondition;
    @Pattern(regexp = "[0-9]{16}",message = "exception.regex.card_number")
    @NotNull(message = NOT_NULL)
    private String cardNumber;
    @Pattern(regexp = "[0-9]{16}",message = "exception.regex.card_number")
    @NotNull(message = NOT_NULL)
    private String targetCardNumber;
    @Digits(integer = 6,fraction = 2,message = "exception.max_digits")
    private BigDecimal amount;
    @NotBlank(message = NOT_BLANK)
    private String message;
}
