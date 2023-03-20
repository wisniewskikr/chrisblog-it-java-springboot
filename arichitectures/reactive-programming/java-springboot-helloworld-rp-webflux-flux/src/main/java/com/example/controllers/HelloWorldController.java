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

import com.example.jsons.HelloWorldJson;

import reactor.core.publisher.Flux;

@RestController
public class HelloWorldController {
	
	Logger logger = LoggerFactory.getLogger(HelloWorldController.class);
	
	private Environment environment;
	
	@Value("${service.helloworld.message}")
	private String message;
	
	@Autowired
	public HelloWorldController(Environment environment) {
		this.environment = environment;
	}

	@RequestMapping(value="/", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<HelloWorldJson> helloWorld() {
				
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
