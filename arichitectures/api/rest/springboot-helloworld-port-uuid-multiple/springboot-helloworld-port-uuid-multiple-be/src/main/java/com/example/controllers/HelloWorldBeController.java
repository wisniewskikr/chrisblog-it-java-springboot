package com.example.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dtos.HelloWorldBeDto;

@RestController
public class HelloWorldBeController {
	
	Logger logger = LoggerFactory.getLogger(HelloWorldBeController.class);
	
	private Environment environment;
	
	@Value("${service.helloworld.message}")
	private String message;
	
	@Autowired
	public HelloWorldBeController(Environment environment) {
		this.environment = environment;
	}

	@GetMapping(value="/")
	public ResponseEntity<HelloWorldBeDto> helloWorld() {
				
		String port = environment.getProperty("local.server.port");
		String uuid = System.getProperty("uuid");
		
		logger.info("Application BE was called with message: {}, port BE: {} and uuid BE: {}", message, port, uuid);
		
		return ResponseEntity.ok(new HelloWorldBeDto(message, port, uuid));
		
	}
	
}