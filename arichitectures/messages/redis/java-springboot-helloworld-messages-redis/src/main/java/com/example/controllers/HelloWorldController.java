package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.redis.Publisher;

@RestController
public class HelloWorldController {

	@Value("${redis.channel}")
	private String channel;
	
	private Publisher publisher;

	@Autowired
	public HelloWorldController(Publisher publisher) {
		this.publisher = publisher;
	}

	@GetMapping(value="/")
	public String send() {
		publisher.publish(channel, "Hello World!");		
		return "Message was sent. Please check Console";
	}

}	