package com.example.controller;

import org.springframework.web.bind.annotation.*;

import com.example.dao.Post;
import com.example.service.HelloWorldService;

@RestController
public class PostController {

    private final HelloWorldService helloWorldService;

    public PostController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @GetMapping
    Post findById() {
        return helloWorldService.findById(1L);
    }

}
