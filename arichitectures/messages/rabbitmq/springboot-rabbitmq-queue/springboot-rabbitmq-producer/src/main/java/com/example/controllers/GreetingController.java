package com.example.controllers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GreetingController {
	
	private static final String API_QUEUE = "greeting-api";
	private static final String LISTENER_QUEUE = "greeting-listener";
	
	private RabbitTemplate rabbitTemplate;

	@Autowired
	public GreetingController(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	@GetMapping(value="/greeting/type/api/name/{name}")
	public String greetingApi(@PathVariable(name = "name") String name) {
		
		String message = "Hello World " + name;
		rabbitTemplate.convertAndSend(API_QUEUE, message);
		return "Done";
		
	}
	
	@GetMapping(value="/greeting/type/listener/name/{name}")
	public String greetingListener(@PathVariable(name = "name") String name) {
		
		String message = "Hello World " + name;
		rabbitTemplate.convertAndSend(LISTENER_QUEUE, message);
		return "Done";
		
	}
	
}