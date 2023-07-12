package com.example.controllers;

import javax.jms.Topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	Logger logger = LoggerFactory.getLogger(HelloWorldController.class);
	
    private JmsTemplate jmsTemplate;
	
	private Topic topic;
	
	@Value("${service.helloworld.message}")
	private String message;
	
	@Autowired
	public HelloWorldController(JmsTemplate jmsTemplate, Topic topic) {
		this.jmsTemplate = jmsTemplate;
		this.topic = topic;
	}

	@GetMapping("/publish")
	public ResponseEntity<String> topicPublish() {
				
		jmsTemplate.convertAndSend(topic, message);
		return ResponseEntity.ok("Topic was published successfuly.");
		
	}	

	@GetMapping("/subscribe")
	public ResponseEntity<String> topicSubscribeSubscriber() {				
		
		String message = (String)jmsTemplate.receiveAndConvert(topic);

   		String response = null;
		if (message == null) {
			response = "Topic wasn't subscribed successfuly by Subscriber. Message is empty";
		} else {
			response = "Topic was subscribed successfuly by Subscriber. Message: " + message;
		}		

		return ResponseEntity.ok(response);
		
	}
	
	@JmsListener(destination = "${jms.topic.name}")
    public void topicSubscribeListener(String message) {
        logger.info("Topic was subscribed successfuly by Listener. Message: " + message);
    }
	
}
