package com.company.firstspringproject.model.handler;

import com.company.firstspringproject.model.exception.ApplicationException;
import com.company.firstspringproject.model.response.ExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class GlobalHandler {
    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ExceptionResponse> handler(ApplicationException e) {
        log.info("exception -> {}",e.getStatus());
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .message(e.getStatus())
                .httpStatus(e.getHttpStatus().value())
                .localDateTime(e.getLocalDateTime())
                .build();
        return new ResponseEntity<>(exceptionResponse,e.getHttpStatus());
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<ExceptionResponse> handler(MaxUploadSizeExceededException e) {
        log.info("exception -> {}",e.getMessage());
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .message(e.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST.value())
                .localDateTime(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(exceptionResponse,HttpStatus.BAD_REQUEST);
    }

}
