package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jsons.HelloWorldJson;
import com.example.services.SentenceService;

@RestController
public class HelloWorldController {
	
	private SentenceService sentenceService;

	@Autowired
	public HelloWorldController(SentenceService sentenceService) {
		this.sentenceService = sentenceService;
	}

	@RequestMapping(value="/")
	public HelloWorldJson helloWorld() {		
		
		try {
			sentenceService.saveSentence("Hello", "World");
		} catch (Exception e) {
			System.err.println(e);
		}
		
		String sentence = sentenceService.readSentence();
		String description = "Transactional method saveSentence(Hello, World) calls two methods: saveFirstWord(Hello) and saveSecondWord(World). "
				+ "There is an exception in saveSecondWord(World) which is transactional and marked as Propagation.NOT_SUPPORTED. "
				+ "So because second method does not support transactions then operations inside this method ARE NOT rolled back. That's why sentence from database is: 'Hello World'";
		
		return new HelloWorldJson(description, sentence);
		
	}
	
}