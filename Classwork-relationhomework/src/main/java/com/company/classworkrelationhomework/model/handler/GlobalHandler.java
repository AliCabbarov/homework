package com.company.classworkrelationhomework.model.handler;

import com.company.classworkrelationhomework.model.dto.exception.ErrorResponse;
import com.company.classworkrelationhomework.model.exception.ApplicationException;
import com.company.classworkrelationhomework.model.exception.BadRequestException;
import com.company.classworkrelationhomework.model.exception.NotFoundException;
import com.company.classworkrelationhomework.util.MessageUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class GlobalHandler extends DefaultErrorAttributes {
    private final MessageUtil messageUtil;

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handler(RuntimeException e, WebRequest webRequest) {
        e.printStackTrace();
        Map<String, Object> errorAttributes = getErrorAttributes(webRequest, ErrorAttributeOptions.defaults());

        errorAttributes.put("error", e.getMessage());
        errorAttributes.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorAttributes);
    }

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ErrorResponse> handler(ApplicationException ex, WebRequest webRequest) {
        ex.printStackTrace();
        ErrorResponse response = ErrorResponse.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .code(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage())
                .path(((ServletRequestAttributes) webRequest).getRequest().getServletPath())
                .detail(ex.getLocalizedMessage())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handler(BadRequestException ex, WebRequest webRequest) {
        log.error("User attempt to register with this username -> {} and password -> {}", ex.getArgs()[0], ex.getArgs()[1]);
        ex.printStackTrace();
        ErrorResponse response = ErrorResponse.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .code(HttpStatus.BAD_REQUEST.value())
                .message(messageUtil.getMessage(ex.getErrorCode().getCode()))
                .path(((ServletRequestAttributes) webRequest).getRequest().getServletPath())
                .detail(messageUtil.getMessage(ex.getErrorCode().getCode()))
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handler(NotFoundException ex, WebRequest webRequest) {
        ex.printStackTrace();
        String path = ((ServletRequestAttributes) webRequest).getRequest().getServletPath();
        ErrorResponse response = ErrorResponse.builder()
                .httpStatus(ex.getErrorCode().getStatus())
                .code(ex.getErrorCode().getStatus().value())
                .message(messageUtil.getMessage(ex.getErrorCode().getCode()))
                .path(path)
                .detail(messageUtil.getMessage(ex.getErrorCode().getDetailCode(), ex.getArgs()))
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handler(MethodArgumentNotValidException ex, WebRequest webRequest) {
        ex.printStackTrace();
        Map<String, Object> details = new HashMap<>();
        ex.getFieldErrors().forEach(fieldError -> details.put(fieldError.getField(), fieldError.getRejectedValue()));
        ErrorResponse response = ErrorResponse.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .code(HttpStatus.BAD_REQUEST.value())
                .message(String.format(ex.getMessage()))
                .path(((ServletRequestAttributes) webRequest).getRequest().getServletPath())
                .detail(ex.getLocalizedMessage())
                .details(details)
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
