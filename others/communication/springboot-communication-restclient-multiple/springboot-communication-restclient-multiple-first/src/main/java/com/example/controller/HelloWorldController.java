package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.HelloWorldDto;
import com.example.service.HelloWorldService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class HelloWorldController {
	
	private final HelloWorldService helloWorldService;

    @GetMapping(value="/message")
	public ResponseEntity<HelloWorldDto> helloWorld() {    
        return ResponseEntity.ok(helloWorldService.getMessage());    
    }
	
}