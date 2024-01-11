package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {	
	
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Value("${topic.name}")
	private String topicName;

	@Autowired
	public GreetingController(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	@GetMapping(value="/greeting/name/{name}")
	public String greetin(@PathVariable(name = "name") String name) {
		
		String message = "Hello World " + name;
		kafkaTemplate.send(topicName, message);
		return "Done";
		
	}
	
}