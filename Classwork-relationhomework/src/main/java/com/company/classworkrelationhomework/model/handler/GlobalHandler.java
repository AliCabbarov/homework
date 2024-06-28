package com.company.classworkrelationhomework.model.handler;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@RestControllerAdvice
public class GlobalHandler extends DefaultErrorAttributes {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String,Object>> handler(RuntimeException e, WebRequest webRequest){
        Map<String, Object> errorAttributes = getErrorAttributes(webRequest, ErrorAttributeOptions.defaults());
        errorAttributes.put("error",e.getMessage());
        return ResponseEntity.ok(errorAttributes);
    }
}
