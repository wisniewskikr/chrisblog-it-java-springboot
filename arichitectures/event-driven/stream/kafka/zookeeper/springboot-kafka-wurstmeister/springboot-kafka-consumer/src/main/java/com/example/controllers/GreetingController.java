package com.example.controllers;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GreetingController {
	
	public static final String TOPIC_NAME = "greeting";
		
	@KafkaListener(topics = TOPIC_NAME)
	public void greetingListener(String message) {		
		System.out.println(message);		
	}
	
}