package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {	
	
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Value("${topic.name}")
	private String topicName;

	@Autowired
	public GreetingController(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	@GetMapping(value="/greeting/partition/{partition}/timestamp/{timestamp}/key/{key}/value/{value}")
	public String greetin(
			@PathVariable(name = "partition") String partitionString,
			@PathVariable(name = "timestamp") String timestampString,
			@PathVariable(name = "key") String keyString,
			@PathVariable(name = "value") String value
			) {
		
		Integer partition = (!"null".equals(partitionString)) ? Integer.valueOf(partitionString) : null;
		Long timestamp = (!"null".equals(timestampString)) ? Long.valueOf(timestampString) : null;
		String key = (!"null".equals(keyString)) ? keyString: null;		
		String message = "Hello World " + value;
				
		if (partition != null && timestamp != null && key != null) {
			kafkaTemplate.send(topicName, partition, timestamp, key, message);
		} else if (partition != null && timestamp == null && key != null) {
			kafkaTemplate.send(topicName, partition, key, message);
		} else if (partition == null && timestamp == null && key != null) {
			kafkaTemplate.send(topicName, key, message);
		} else {
			kafkaTemplate.send(topicName, message);
		}				
		
		return "Done";
		
	}
	
}