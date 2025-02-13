package com.example.keycloak.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {

    @GetMapping
    public String hello() {
        return "Hello World!";
    }
    
    @GetMapping("/user")
    @PreAuthorize("hasRole('user_role')")
    public String helloUser() {
        return "Hello World, User!";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('admin_role')")
    public String helloAdmin() {
        return "Hello World, Admin!";
    }

}
