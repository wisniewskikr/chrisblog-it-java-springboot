package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.redis.Publisher;
import com.example.redis.Subscriber;

@RestController
public class HelloWorldController {
	
	private Publisher publisher;

	@Value("${redis.channel}") 
	private String channel;

	@Autowired
	public HelloWorldController(Publisher publisher, Subscriber subscriber, @Value("${redis.channel}") String channel) {
		this.publisher = publisher;
		subscriber.subscribe(channel);
	}
	
	@GetMapping(value="/")
	public String send() {		
		publisher.publish(channel, "Hello World!");		
		return "Message was sent. Please check Console";
	}

	

}	