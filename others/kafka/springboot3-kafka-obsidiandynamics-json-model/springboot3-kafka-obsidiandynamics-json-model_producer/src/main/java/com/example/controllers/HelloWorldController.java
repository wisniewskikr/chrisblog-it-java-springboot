package com.example.controllers;

import com.example.models.HelloWorldModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/producer")
public class HelloWorldController {	
	
	private final KafkaTemplate<String, HelloWorldModel> kafkaTemplate;
	
	@Value("${topic.name}")
	private String topicName;

	@Autowired
	public HelloWorldController(KafkaTemplate<String, HelloWorldModel> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	@GetMapping
	public String helloWorld(@RequestParam String name) {
		
		String message = "Hello World " + name;
		kafkaTemplate.send(topicName, new HelloWorldModel(message));
		return "The message was sent to Consumer via Kafka";
		
	}
	
}