package com.example.keycloak.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
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
    public String helloUser(@AuthenticationPrincipal Jwt jwt) {

        String email = jwt.getClaim("email");
        return "Hello World, " + email + "!";

    }

}
