package com.example.keycloak.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class DemoController {

    @GetMapping("/public")
    public String hello() {
        return "Hello World, Public!";
    }

    @GetMapping("/user")
    public String helloUser() {
        return "Hello World, User!";
    }

    @GetMapping("/admin")
    public String helloAdmin() {
        return "Hello World, Admin!";
    }

}
