package com.example.controllers;

import org.springframework.web.bind.annotation.*;

import com.example.dtos.HelloWorldDto;
import com.example.services.HelloWorldService;

@RestController
public class HelloWorldController {

    private final HelloWorldService helloWorldService;

    public HelloWorldController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @GetMapping
    HelloWorldDto findById() {
        return helloWorldService.findById(1L);
    }

}
