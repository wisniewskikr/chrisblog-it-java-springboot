package com.example.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.jsons.DisplayJson;
import com.example.jsons.TextJson;

import reactor.core.publisher.Mono;

@RestController
public class DisplayController {
	
	private Environment environment;

	private WebClient webClient;
	
	private final static String MESSAGE = "Hello World from Display Service!";
	
	@Value("${text.service.url}")
	private String textServiceUrl;
	
	@Autowired
	public DisplayController(Environment environment, WebClient webClient) {
		this.environment = environment;
		this.webClient = webClient;
	}

	@RequestMapping(value="/")
	public DisplayJson greeting() {
		
		String displayPort = environment.getProperty("local.server.port");
		Mono<TextJson> mono = this.webClient.get()
	            .uri(textServiceUrl)
	            .retrieve()
	            .bodyToMono(TextJson.class);
		
		mono.subscribe(x -> System.out.println(x.getMessage()));
		System.out.println(MESSAGE);
		
		return new DisplayJson(MESSAGE, displayPort, null);
		
	}
	
}