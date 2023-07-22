package com.example.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dtos.HelloWorldDto;
import com.example.services.MessageService;

@RestController
public class HelloWorldController {
	
	Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

	private MessageService messageService;

	@Autowired
	public HelloWorldController(MessageService messageService) {
		this.messageService = messageService;
	}

	@GetMapping("/")
	public ResponseEntity<HelloWorldDto> helloWorld() {

		String message = messageService.getMessage();
		
		logger.info("Application was called with message: {}", message);
		
		return ResponseEntity.ok(new HelloWorldDto(message));
		
	}
	
}
