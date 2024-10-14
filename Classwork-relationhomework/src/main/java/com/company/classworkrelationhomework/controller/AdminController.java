package com.company.classworkrelationhomework.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admins")
public class AdminController {
    @GetMapping
    public ResponseEntity<String> get(){
        return ResponseEntity.ok("hello admins");
    }
}
