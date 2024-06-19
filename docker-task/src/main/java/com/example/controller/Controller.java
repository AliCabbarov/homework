package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/customers")
    public String get(){
        return "welcome from customer ms";
        //git commit test

        //
    }
}
