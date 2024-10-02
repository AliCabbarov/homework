package com.company.classworkrelationhomework.model.dto.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Map;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ErrorResponse {
    String message;
    int code;
    String detail;
    String path;
    HttpStatus httpStatus;
    Map<String, Object> details;
}
