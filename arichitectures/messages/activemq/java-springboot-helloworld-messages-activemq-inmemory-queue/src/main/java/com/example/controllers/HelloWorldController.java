package com.example.controllers;

import javax.jms.Queue;

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

	@Value("${service.helloworld.message}")
	private String message;
	
	@Autowired
	public HelloWorldController(JmsTemplate jmsTemplate, Queue queue) {
		this.jmsTemplate = jmsTemplate;
		this.queue = queue;
	}

	@GetMapping("/produce")
	public ResponseEntity<String> produce() {
				
		jmsTemplate.convertAndSend(queue, message);
		return ResponseEntity.ok("Queue was produced successfuly.");
		
	}	

	@GetMapping("/consume")
	public ResponseEntity<String> consumeByConsumer() {				
		
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
    public void consumeByListener(String message) {
        logger.info("Queue was consumed successfuly by Listener. Message: " + message);
    }
	
}
