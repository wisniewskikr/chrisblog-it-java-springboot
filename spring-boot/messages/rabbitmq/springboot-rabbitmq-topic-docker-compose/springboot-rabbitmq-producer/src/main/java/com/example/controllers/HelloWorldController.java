package com.example.controllers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.configs.TopicJmsConfig;


@RestController
public class HelloWorldController {
	
	private RabbitTemplate rabbitTemplate;

	@Autowired
	public HelloWorldController(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	@GetMapping(value="/helloworld/name/{name}")
	public String helloWorldApi(@PathVariable(name = "name") String name) {
		
		String message = "Hello World " + name;
		rabbitTemplate.convertAndSend(TopicJmsConfig.FANOUT, "", message);
		return "Done";
		
	}
	
}