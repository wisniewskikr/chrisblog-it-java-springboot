package com.example.keycloak.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.keycloak.dto.HelloWorldDto;

@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {

    @GetMapping("/public")
    public ResponseEntity<HelloWorldDto> helloPublic() {
        return ResponseEntity.ok(new HelloWorldDto("Hello World, Public!"));
    }

    @GetMapping("/secured")
    public ResponseEntity<HelloWorldDto> helloSecured() {
        return ResponseEntity.ok(new HelloWorldDto("Hello World, Secured!"));
    }

}
