package com.example.controllers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {
	
	private static final String API_QUEUE = "helloworld-api";
	private static final String LISTENER_QUEUE = "helloworld-listener";
	
	private RabbitTemplate rabbitTemplate;

	@Autowired
	public HelloWorldController(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	@GetMapping(value="/helloworld/type/api/name/{name}")
	public String helloWorldApi(@PathVariable(name = "name") String name) {
		
		String message = "Hello World " + name;
		rabbitTemplate.convertAndSend(API_QUEUE, message);
		return "Done";
		
	}
	
	@GetMapping(value="/helloworld/type/listener/name/{name}")
	public String helloWorldListener(@PathVariable(name = "name") String name) {
		
		String message = "Hello World " + name;
		rabbitTemplate.convertAndSend(LISTENER_QUEUE, message);
		return "Done";
		
	}
	
}