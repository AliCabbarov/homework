package com.company.aoplesson.controller;

import com.company.aoplesson.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @GetMapping
    public String getUser(){
        return new User("a","b").toString();
    }
    @GetMapping("/test")
    public String test(@Param("x") int x){
        log.info("methode body!!!");
        if (x == 10){
            throw new RuntimeException("wrong value!!!");
        }
        return "hello world";
    }

}
