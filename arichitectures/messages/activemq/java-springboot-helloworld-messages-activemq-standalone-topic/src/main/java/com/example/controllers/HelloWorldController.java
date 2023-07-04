package com.example.controllers;

import javax.jms.Queue;
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

    private Queue queue;

	private Topic topic;
	
	@Value("${service.helloworld.message}")
	private String message;
	
	@Autowired
	public HelloWorldController(JmsTemplate jmsTemplate, Queue queue, Topic topic) {
		this.jmsTemplate = jmsTemplate;
		this.queue = queue;
		this.topic = topic;
	}

	// ***** TOPIC ***** //

	@GetMapping("/topic/publish")
	public ResponseEntity<String> topicPublish() {
				
		jmsTemplate.convertAndSend(topic, message);
		return ResponseEntity.ok("Topic was pulblished successfuly.");
		
	}	

	@GetMapping("/topic/subscribe")
	public ResponseEntity<String> topicSubscribeSubscriber() {				
		
		jmsTemplate.setReceiveTimeout(JmsTemplate.RECEIVE_TIMEOUT_NO_WAIT);		
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

	// ***** QUEUE ***** //

	@GetMapping("/queue/produce")
	public ResponseEntity<String> queueProduce() {
				
		jmsTemplate.convertAndSend(queue, message);
		return ResponseEntity.ok("Queue was produced successfuly.");
		
	}	

	@GetMapping("/queue/consume")
	public ResponseEntity<String> queueConsumeConsumer() {				
		
		jmsTemplate.setReceiveTimeout(JmsTemplate.RECEIVE_TIMEOUT_NO_WAIT);		
		String message = (String)jmsTemplate.receiveAndConvert(queue);

   		String response = null;
		if (message == null) {
			response = "Queue wasn't consumed successfuly by Consumer. Message is empty";
		} else {
			response = "Queue was consumed successfuly by Consumer. Message: " + message;
		}		

		return ResponseEntity.ok(response);
		
	}
	
	@JmsListener(destination = "${jms.queue.name}")
    public void queueConsumeListener(String message) {
        logger.info("Queue was consumed successfuly by Listener. Message: " + message);
    }
	
}
