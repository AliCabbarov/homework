package com.company.classworkrelationhomework.model.handler;

import com.company.classworkrelationhomework.model.dto.exception.ErrorResponse;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalHandler extends DefaultErrorAttributes {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handler(RuntimeException e, WebRequest webRequest) {
        e.printStackTrace();
        Map<String, Object> errorAttributes = getErrorAttributes(webRequest, ErrorAttributeOptions.defaults());

        errorAttributes.put("error", e.getMessage());
        errorAttributes.put("status", HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorAttributes);
    }

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ErrorResponse> handler(ApplicationException ex, WebRequest webRequest) {
        ErrorResponse response = ErrorResponse.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .code(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage())
                .path(webRequest.getContextPath())
                .detail(ex.getLocalizedMessage())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handler(NotFoundException ex, WebRequest webRequest) {
        ErrorResponse response = ErrorResponse.builder()
                .httpStatus(HttpStatus.NOT_FOUND)
                .code(HttpStatus.NOT_FOUND.value())
                .message(String.format(ex.getMessage() + "with given data {%s}", ex.getNotFoundedData()))
                .path(webRequest.getContextPath())
                .detail(ex.getLocalizedMessage())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handler(MethodArgumentNotValidException ex, WebRequest webRequest) {
        Map<String,Object> details = new HashMap<>();
        ex.getFieldErrors().forEach(fieldError -> details.put(fieldError.getField(),fieldError.getRejectedValue()));
        ErrorResponse response = ErrorResponse.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .code(HttpStatus.BAD_REQUEST.value())
                .message(String.format(ex.getMessage()))
                .path(webRequest.getContextPath())
                .detail(ex.getLocalizedMessage())
                .details(details)
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
