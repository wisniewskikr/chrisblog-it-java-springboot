package com.example.controllers;

import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.jsons.HelloWorldJson;

import reactor.core.publisher.Flux;

@RestController
public class HelloWorldController {
	
	Logger logger = LoggerFactory.getLogger(HelloWorldController.class);
	
	private Environment environment;
	private WebClient webClient;
	
	@Value("${service.helloworld.message}")
	private String message;
	
	@Value("${be.uri}")
	private String beUri;
	
	@Autowired
	public HelloWorldController(Environment environment, WebClient webClient) {
		this.environment = environment;
		this.webClient = webClient;
	}
	
	@RequestMapping(value="/", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
//	@RequestMapping(value="/", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<HelloWorldJson> helloWorld() {
		
		return this.webClient.get()
        .uri(beUri)
        .retrieve()
        .bodyToFlux(HelloWorldJson.class);
		
	}

	@RequestMapping(value="/be", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
//	@RequestMapping(value="/be", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<HelloWorldJson> helloWorldBe() {
				
		String port = environment.getProperty("local.server.port");
		String uuid = System.getProperty("uuid");
		
		Flux<HelloWorldJson> flux = Flux.just(
				new HelloWorldJson(message + " 1", port, uuid + "1"),
				new HelloWorldJson(message + " 2", port, uuid + "2"),
				new HelloWorldJson(message + " 3", port, uuid + "3"),
				new HelloWorldJson(message + " 4", port, uuid + "4"),
				new HelloWorldJson(message + " 5", port, uuid + "5")
				)
				.delayElements(Duration.ofSeconds(2));
		
		logger.info("Application was called with message: {}, port: {} and uuid: {}", message, port, uuid);
		
		return flux;
		
	}
	
}
