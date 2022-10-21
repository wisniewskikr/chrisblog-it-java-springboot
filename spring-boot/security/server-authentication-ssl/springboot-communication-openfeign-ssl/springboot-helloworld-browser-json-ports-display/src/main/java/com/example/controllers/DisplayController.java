package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.feignclients.TextFeignClient;
import com.example.jsons.DisplayJson;
import com.example.jsons.TextJson;

@RestController
public class DisplayController {
	
	private Environment environment;

	private TextFeignClient textFeignClient;
	
	@Autowired
	public DisplayController(Environment environment, TextFeignClient textFeignClient) {
		this.environment = environment;
		this.textFeignClient = textFeignClient;
	}

	@RequestMapping(value="/")
	public DisplayJson greeting() {
		
		String displayPort = environment.getProperty("local.server.port");
		TextJson textJson = textFeignClient.provideText();

		return new DisplayJson(textJson.getMessage(), displayPort, textJson.getPort());
		
	}
	
}