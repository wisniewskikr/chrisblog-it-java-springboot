package com.example.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.jsons.DisplayJson;
import com.example.jsons.TextJson;

import reactor.core.publisher.Flux;

@RestController
public class DisplayController {
	
	private Environment environment;

	private WebClient webClient;
	
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
		Flux<TextJson> flux = this.webClient.get()
	            .uri(textServiceUrl)
	            .retrieve()
	            .bodyToFlux(TextJson.class);

		List<TextJson> list = flux.collectList().block();
		StringBuffer sb = new StringBuffer();
		String textPort = null;
		for (TextJson textJson : list) {
			sb.append(textJson.getMessage());
			sb.append("; ");
			textPort = textJson.getPort();
		}
		
		return new DisplayJson(sb.toString(), displayPort, textPort);
		
	}
	
}