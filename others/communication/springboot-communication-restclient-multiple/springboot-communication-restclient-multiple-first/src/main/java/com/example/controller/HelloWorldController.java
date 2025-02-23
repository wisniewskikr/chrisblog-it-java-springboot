package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.HelloWorldDto;
import com.example.service.HelloWorldService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class HelloWorldController {
	
	private final HelloWorldService helloWorldService;

    @GetMapping(value="/")
	public ResponseEntity<HelloWorldDto> helloWorld() {    
        return ResponseEntity.ok(helloWorldService.getMessage());    
    }
	
}