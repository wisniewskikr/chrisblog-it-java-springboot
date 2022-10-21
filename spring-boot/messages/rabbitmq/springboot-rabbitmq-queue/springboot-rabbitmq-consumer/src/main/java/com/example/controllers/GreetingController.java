package com.example.controllers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping(value="/greeting/type/api/message")
	public String greetingApi() {		
		return rabbitTemplate.receiveAndConvert(API_QUEUE).toString();		
	}
	
	@RabbitListener(queues = LISTENER_QUEUE)
	public void greetingListener(String message) {		
		System.out.println(message);		
	}
	
}