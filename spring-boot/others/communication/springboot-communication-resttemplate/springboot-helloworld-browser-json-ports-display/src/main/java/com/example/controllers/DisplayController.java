package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.jsons.DisplayJson;
import com.example.jsons.TextJson;

@RestController
public class DisplayController {
	
	private Environment environment;

	private RestTemplate restTemplate;
	
	@Value("${text.service.url}")
	private String textServiceUrl;
	
	@Autowired
	public DisplayController(Environment environment, RestTemplate restTemplate) {
		this.environment = environment;
		this.restTemplate = restTemplate;
	}

	@RequestMapping(value="/")
	public DisplayJson greeting() {
		
		String displayPort = environment.getProperty("local.server.port");
		ResponseEntity<TextJson> responseEntity = restTemplate.getForEntity(textServiceUrl, TextJson.class);
		TextJson textJson = responseEntity.getBody();
		
		return new DisplayJson(textJson.getMessage(), displayPort, textJson.getPort());
		
	}
	
}