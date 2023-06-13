package com.example.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.jsons.HelloWorldJson;

@Controller
public class HelloWorldController {
	
	Logger logger = LoggerFactory.getLogger(HelloWorldController.class);
	
	private Environment environment;
	
	@Value("${service.helloworld.message}")
	private String message;
	
	@Autowired
	public HelloWorldController(Environment environment) {
		this.environment = environment;
	}

	@QueryMapping
	public HelloWorldJson helloWorld() {
				
		String port = environment.getProperty("local.server.port");
		String uuid = System.getProperty("uuid");
		
		logger.info("Application was called with message: {}, port: {} and uuid: {}", message, port, uuid);
		
		return new HelloWorldJson(message, port, uuid);
		
	}
	
}