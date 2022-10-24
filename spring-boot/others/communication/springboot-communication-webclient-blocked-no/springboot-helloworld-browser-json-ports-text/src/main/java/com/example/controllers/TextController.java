package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jsons.TextJson;

@RestController
public class TextController {
	
private static final int FIVE_SECONDS = 5;
private Environment environment;	
	
	@Autowired
	public TextController(Environment environment) {
		this.environment = environment;
	}

	@RequestMapping(value="/")
	public TextJson greeting() {
		
		try {
		    Thread.sleep(FIVE_SECONDS * 1000);
		} catch (InterruptedException ie) {
		    Thread.currentThread().interrupt();
		}
		
		String port = environment.getProperty("local.server.port");
		return new TextJson("Hello World from Text Service!", port);
		
	}
	
}