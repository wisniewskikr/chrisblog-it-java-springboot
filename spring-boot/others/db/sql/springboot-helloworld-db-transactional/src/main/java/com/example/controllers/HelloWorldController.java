package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.services.HelloWorldService;

@RestController
public class HelloWorldController {
	
	private HelloWorldService helloWorldService;

	@Autowired
	public HelloWorldController(HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}

	@RequestMapping(value="/")
	public String helloWorld() {
		
		try {
			helloWorldService.saveTextWithErrorWithoutTransaction("Hello", "World");
		} catch (Exception e) {
			System.err.println(e);
		}		
		
		String text = helloWorldService.readTextWithErrorWithoutTransaction();
		
		return text;		
	}
	
}