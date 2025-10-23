package com.example.keycloak.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class DemoController {

    @GetMapping("/public")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/user")
    public String helloUser() {
        return "Hello World, User!";
    }

}
