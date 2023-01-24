package com.example.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jsons.HelloWorldBeJson;

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

	@RequestMapping(value="/")
	public HelloWorldBeJson helloWorld() {
				
		String port = environment.getProperty("local.server.port");
		String uuid = System.getProperty("uuid");
		
		logger.info("Application BE was called with message: {}, port BE: {} and uuid BE: {}", message, port, uuid);
		
		return new HelloWorldBeJson(message, port, uuid);
		
	}
	
}