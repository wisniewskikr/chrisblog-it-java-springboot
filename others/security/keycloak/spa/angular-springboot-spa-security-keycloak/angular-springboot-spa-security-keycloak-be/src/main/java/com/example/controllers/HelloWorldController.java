package com.example.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @CrossOrigin("http://localhost:4200/")
    @GetMapping("/")
    public String displayMessage() {
        return "Hello World!";
    }
    
}
