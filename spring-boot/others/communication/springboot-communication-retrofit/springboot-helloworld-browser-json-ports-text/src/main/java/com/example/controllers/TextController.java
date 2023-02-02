package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dtos.TextDto;

@RestController
public class TextController {
	
private Environment environment;

	@Value("${text.value}")
	private String text;
	
	@Autowired
	public TextController(Environment environment) {
		this.environment = environment;
	}

	@RequestMapping(value="/")
	public TextDto greeting() {
		
		String port = environment.getProperty("local.server.port");
		return new TextDto(text, port);
		
	}
	
}