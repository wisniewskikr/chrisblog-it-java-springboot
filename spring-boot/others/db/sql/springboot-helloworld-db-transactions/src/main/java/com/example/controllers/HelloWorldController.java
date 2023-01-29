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
		String description = "Transactional method saveSentence(Hello, World) saves words to database. "
				+ "But there is an exception at the end of this method so all database operations are rolled back. That's why final sentence from database is: 'null null'";
		
		return new HelloWorldJson(description, sentence);
		
	}
	
}