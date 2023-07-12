package com.example.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jsons.HelloWorldJson;

import reactor.core.publisher.Mono;

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
//	@RequestMapping(value="/", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Mono<HelloWorldJson> helloWorld() {
				
		String port = environment.getProperty("local.server.port");
		String uuid = System.getProperty("uuid");
		
		Mono<HelloWorldJson> mono = Mono.just(new HelloWorldJson(message, port, uuid));
		
		logger.info("Application was called with message: {}, port: {} and uuid: {}", message, port, uuid);
		
		return mono;
		
	}
	
}
