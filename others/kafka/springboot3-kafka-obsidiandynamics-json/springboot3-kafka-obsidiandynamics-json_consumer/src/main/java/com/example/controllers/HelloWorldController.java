package com.example.controllers;

import com.example.models.HelloWorldModel;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/consumer")
public class HelloWorldController {

	private String message = "There is no message from Producer via Kafka yet";

	@GetMapping
	public String helloWorld() {		
		return "Message from Producer via Kafka is: " + message;
		
	}
		
	@KafkaListener(topics = "#{'${topic.name}'}")
	public void helloWorldListener(HelloWorldModel helloWorldModel) {
		this.message = helloWorldModel.getMessage();
		System.out.println(message);		
	}
	
}