package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.redis.Publisher;
import com.example.redis.Subscriber;

@RestController
public class HelloWorldController {

	@Value("${redis.channel}")
	private String channel;
	
	private Publisher publisher;
	private Subscriber subscriber;

	@Autowired
	public HelloWorldController(Publisher publisher, Subscriber subscriber) {
		this.publisher = publisher;
		this.subscriber = subscriber;
	}
	
	@GetMapping(value="/")
	public String send() {
		subscriber.subscribe(channel);
		publisher.publish(channel, "Hello World!");		
		return "Message was sent. Please check Console";
	}

	

}	