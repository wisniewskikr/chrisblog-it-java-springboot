package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.HelloWorldDto;

@RestController
@RequestMapping("/api/v1")
public class HelloWorldController {
	
    @GetMapping(value="/message")
	public ResponseEntity<HelloWorldDto> helloWorld() {    
        return ResponseEntity.ok(new HelloWorldDto("Hello World!"));    
    }
	
}