package com.example.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/status")
@AllArgsConstructor
public class Resilience4JController {

    @GetMapping
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok("OK");
    }

}
