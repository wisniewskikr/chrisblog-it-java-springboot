package com.example.controller;

import org.springframework.web.bind.annotation.*;

import com.example.dao.HelloWorldDto;
import com.example.service.HelloWorldService;

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
