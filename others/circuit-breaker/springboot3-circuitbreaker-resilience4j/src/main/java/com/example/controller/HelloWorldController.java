package com.example.controller;

import com.example.service.HelloWorldService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/status")
@AllArgsConstructor
public class HelloWorldController {

    private final HelloWorldService helloWorldService;

    @GetMapping
    public ResponseEntity<String> getStatus() {

        String message = helloWorldService.sayHello();
        return ResponseEntity.ok(message);

    }

}
