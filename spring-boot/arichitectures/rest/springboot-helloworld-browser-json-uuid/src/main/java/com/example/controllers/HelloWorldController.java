package com.example.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jsons.HelloWorldJson;

@RestController
public class HelloWorldController {
	
	Logger logger = LoggerFactory.getLogger(HelloWorldController.class);
	
	@Value("${service.helloworld.message}")
	private String message;

	@RequestMapping(value="/")
	public HelloWorldJson helloWorld() {
				
		String uuid = System.getProperty("uuid");
		logger.info("Hello World from application: " + uuid);
		return new HelloWorldJson(message, uuid);
		
	}
	
}