package com.example.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jsons.HelloWorldJson;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class HelloWorldController {

	@RequestMapping(value="/")
	public String greeting() throws JsonProcessingException {
		HelloWorldJson greeting = new HelloWorldJson("Hello World!");
		String json = new ObjectMapper().writeValueAsString(greeting);
		System.out.println(json);
		return "Please check Console - greeting message was displayed there.";
		
	}
	
}