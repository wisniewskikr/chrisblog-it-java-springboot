package com.example.controllers;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {
		
	@KafkaListener(topics = "#{'${topic.name}'}")
	public void helloWorldListener(String message) {		
		System.out.println(message);		
	}
	
}