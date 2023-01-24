package com.example.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.jsons.HelloWorldBeJson;
import com.example.jsons.HelloWorldFeJson;

@RestController
public class HelloWorldFeController {
	
	Logger logger = LoggerFactory.getLogger(HelloWorldFeController.class);
	
	private Environment environment;
	
	private WebClient webClient;
	
//	@Value("${tmp}")
	private String helloWorldBeUrl = "http://localhost:9090";
	
	@Autowired
	public HelloWorldFeController(Environment environment, WebClient webClient) {
		this.environment = environment;
		this.webClient = webClient;
	}

	@RequestMapping(value="/")
	public HelloWorldFeJson helloWorld() {
		
		HelloWorldBeJson helloWorldBeJson = this.webClient.get()
	            .uri(helloWorldBeUrl)
	            .retrieve()
	            .bodyToMono(HelloWorldBeJson.class)
	            .block();
				
		String message = helloWorldBeJson.getMessage();
		String portBe = helloWorldBeJson.getPortBe();
		String uuidBe = helloWorldBeJson.getUuidBe();
		String portFe = environment.getProperty("local.server.port");
		String uuidFe = System.getProperty("uuid");
		
		logger.info("Application FE was called with message: {}, port FE: {}, uuid FE: {}, port BE: {} and uuid BE: {}", message, portFe, uuidFe, portBe, uuidBe);
		
		return new HelloWorldFeJson(message, portFe, uuidFe, portBe, uuidBe);
		
	}
	
}