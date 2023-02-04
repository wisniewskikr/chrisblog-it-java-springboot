package com.example.controllers;

import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jsons.HelloWorldJson;
import com.example.secrets.CredentialsSecret;
import com.example.service.CredentialsService;

@RestController
public class HelloWorldController {
	
	Logger logger = LoggerFactory.getLogger(HelloWorldController.class);
	
	@Value("${service.helloworld.message}")
	private String message;
	
	private CredentialsService credentialsService;
	
	@Autowired
	public HelloWorldController(CredentialsService credentialsService) {
		this.credentialsService = credentialsService;
	}

	@RequestMapping(value="/")
	public HelloWorldJson helloWorld() throws URISyntaxException {
		
		credentialsService.saveCredentials(new CredentialsSecret(message));
		CredentialsSecret credentials = credentialsService.findCredentials();
		String secretMessage = credentials.getMessage();
					
		logger.info("Application was called with secret message: {}", secretMessage);		
		return new HelloWorldJson(secretMessage);
		
	}
	
}