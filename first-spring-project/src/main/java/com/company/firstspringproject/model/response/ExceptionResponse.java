package com.company.firstspringproject.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@Getter
@RequiredArgsConstructor
@Builder
public class ExceptionResponse {
    private final String message;
    private final int httpStatus;
    private final LocalDateTime localDateTime;
}
