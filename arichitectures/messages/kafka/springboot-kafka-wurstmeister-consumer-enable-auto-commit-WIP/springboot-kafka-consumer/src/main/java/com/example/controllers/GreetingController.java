package com.example.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GreetingController {
	
	@Value("${consumer.id}")
	private String consumerId;
	
	@Value("${spring.kafka.consumer.enable.auto.commit}")
	private Boolean enableAutoCommit;
		
	@KafkaListener(topics = "#{'${topic.name}'}")
	public void greetingListener(String message) {		
		System.out.println(String.format("Consumer %s, enable auto commit %s, message: %s", consumerId, Boolean.toString(enableAutoCommit), message));		
	}
	
}