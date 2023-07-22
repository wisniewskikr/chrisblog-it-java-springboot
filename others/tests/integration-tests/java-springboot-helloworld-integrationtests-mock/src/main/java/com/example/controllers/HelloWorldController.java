package com.example.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dtos.HelloWorldDto;

@RestController
public class HelloWorldController {
	
	Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

	@GetMapping("/")
	public ResponseEntity<HelloWorldDto> helloWorld() {

		String message = "Hello World!";
		
		logger.info("Application was called with message: {}", message);
		
		return ResponseEntity.ok(new HelloWorldDto(message));
		
	}
	
}
