package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.publishers.MqttPublisher;

@RestController
public class HelloWorldController {
	
	@Value("${service.helloworld.message}")
	private String message;

	private MqttPublisher publisher;

	@Autowired
	public HelloWorldController(MqttPublisher publisher) {
		this.publisher = publisher;
	}

	@GetMapping("/")
	public ResponseEntity<?> publish(){

		try {
			publisher.senToMqtt(message, "myTopic");
			return ResponseEntity.ok("Success");
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.ok("fail");
		}

	}
	

	
}