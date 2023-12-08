package com.company.demo.handler;

import com.company.demo.model.exception.NotFoundException;
import com.company.demo.util.MessageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalHandler extends DefaultErrorAttributes {
    private final MessageUtil messageUtil;
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,Object>> handle(MethodArgumentNotValidException exception, WebRequest webRequest){
        Map<String,Object> invalidFields = new HashMap<>();
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, ErrorAttributeOptions.defaults());

        exception.getFieldErrors().forEach(fieldError -> invalidFields.put(fieldError.getField(), messageUtil.getMessage(fieldError.getDefaultMessage(), new Object[]{})));

        errorAttributes.put("error",invalidFields);
        errorAttributes.put("status",HttpStatus.BAD_REQUEST.value());
        errorAttributes.put("path",((ServletWebRequest)webRequest).getRequest().getRequestURI());

        return new ResponseEntity<>(errorAttributes, HttpStatus.BAD_REQUEST);
    }@ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Map<String,Object>> handle(NotFoundException exception, WebRequest webRequest){

        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, ErrorAttributeOptions.defaults());

        errorAttributes.put("error",messageUtil.getMessage("exception.not_found",exception.getMessage()));
        errorAttributes.put("status",HttpStatus.BAD_REQUEST.value());
        errorAttributes.put("path",((ServletWebRequest)webRequest).getRequest().getRequestURI());

        return new ResponseEntity<>(errorAttributes, HttpStatus.BAD_REQUEST);
    }

}
