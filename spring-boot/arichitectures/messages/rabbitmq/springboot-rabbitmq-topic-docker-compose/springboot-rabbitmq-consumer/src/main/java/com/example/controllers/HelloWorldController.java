package com.example.controllers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping(value="/helloworld/type/api/message")
	public String helloWorldApi() {		
		return rabbitTemplate.receiveAndConvert(API_QUEUE).toString();		
	}
	
	@RabbitListener(queues = LISTENER_QUEUE)
	public void helloWorldListener(String message) {		
		System.out.println(message);		
	}
	
}