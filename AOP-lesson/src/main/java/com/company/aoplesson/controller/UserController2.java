package com.company.aoplesson.controller;

import com.company.aoplesson.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users2")
public class UserController2 {
    @GetMapping
    public String getUser(){
        return new User("a","b").toString();
    }
    @GetMapping("/test")
    public String test(){
        return "hello world";
    }

}
