package com.example.controllers;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.kafka.support.KafkaHeaders;


@RestController
public class GreetingController {
	
	@KafkaListener(topicPartitions = 
			@TopicPartition(topic = "#{'${topic.name}'}", partitions = { "0" }))
	public void greetingListenerForPartition0(@Payload String message,
	        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
	        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,	        
	        @Header(KafkaHeaders.RECEIVED_TIMESTAMP) Long ts) {	
		
		System.out.println("greetingListenerForPartition0()");
		System.out.println("Key: " + key);
		System.out.println("Partition: " + partition);
		System.out.println("Timestamp: " + ts);
		System.out.println("Message: " + message);
		
	}
	
	@KafkaListener(topicPartitions = 
			@TopicPartition(topic = "#{'${topic.name}'}", partitions = { "1" }))
	public void greetingListenerForPartition1(@Payload String message,
	        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
	        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,	        
	        @Header(KafkaHeaders.RECEIVED_TIMESTAMP) Long ts) {	
		
		System.out.println("greetingListenerForPartition1()");
		System.out.println("Key: " + key);
		System.out.println("Partition: " + partition);
		System.out.println("Timestamp: " + ts);
		System.out.println("Message: " + message);
		
	}
	
}