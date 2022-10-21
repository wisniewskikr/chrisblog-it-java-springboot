package com.example.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GreetingController {
	
	@Value("${consumer.id}")
	private String consumerId;
	
	@Value("${spring.kafka.consumer.auto.offset.reset}")
	private String autoOffsetReset;
		
	@KafkaListener(topics = "#{'${topic.name}'}")
	public void greetingListener(String message) {		
		System.out.println(String.format("Consumer %s, offset reset type %s, message: %s", consumerId, autoOffsetReset, message));		
	}
	
}