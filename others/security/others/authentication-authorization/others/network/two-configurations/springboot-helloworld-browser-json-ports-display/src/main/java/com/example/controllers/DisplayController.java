package com.example.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.jsons.DisplayJson;
import com.example.jsons.TextJson;

@RestController
public class DisplayController {
	
	private Environment environment;

	private WebClient webClient;
	
	@Value("${text.service.url.apikey}")
	private String textServiceUrlApiKey;
	@Value(value = "${api.key.name}")
    private String apiKeyName;
    @Value(value = "${api.key.value}")
    private String apiKeyValue;
    
    @Value("${text.service.url.basic}")
	private String textServiceUrlBasic;
    @Value(value = "${basic.username}")
    private String basicUsername;
    @Value(value = "${basic.password}")
    private String basicPassword;    
	
	@Autowired
	public DisplayController(Environment environment, WebClient webClient) {
		this.environment = environment;
		this.webClient = webClient;
	}

	@RequestMapping(value="/apikey")
	public DisplayJson apiKey() {
		
		String displayPort = environment.getProperty("local.server.port");
		TextJson textJson = this.webClient.get()
	            .uri(textServiceUrlApiKey)
	            .headers(headers -> headers.set(apiKeyName, apiKeyValue))
	            .retrieve()
	            .bodyToMono(TextJson.class)
	            .block();
		
		return new DisplayJson(textJson.getMessage(), displayPort, textJson.getPort());
		
	}
	
	@RequestMapping(value="/basic")
	public DisplayJson basic() {
		
		String displayPort = environment.getProperty("local.server.port");
		TextJson textJson = this.webClient.get()
	            .uri(textServiceUrlBasic)
	            .headers(headers -> headers.setBasicAuth(basicUsername, basicPassword))
	            .retrieve()
	            .bodyToMono(TextJson.class)
	            .block();
		
		return new DisplayJson(textJson.getMessage(), displayPort, textJson.getPort());
		
	}
	
}