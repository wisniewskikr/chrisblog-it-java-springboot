package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jsons.HelloWorldJson;
import com.example.services.HelloWorldService;

@RestController
public class HelloWorldController {
	
	private HelloWorldService helloWorldService;

	@Autowired
	public HelloWorldController(HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}

	@RequestMapping(value="/")
	public HelloWorldJson helloWorld() {		
		
		String text = getText();
		String textAfterErrorWithTransaction = getTextAfterErrorWithTransaction();
		
		return new HelloWorldJson(text, textAfterErrorWithTransaction);
		
	}
	
	private String getText() {
		
		try {
			helloWorldService.saveText("Hello", "World");
		} catch (Exception e) {
			System.err.println(e);
		}		
		
		return helloWorldService.readText();
		
	}
	
	private String getTextAfterErrorWithTransaction() {
		
		try {
			helloWorldService.saveTextWithErrorTransactionPropagationRequiresNew("Hello", "World");
		} catch (Exception e) {
			System.err.println(e);
		}		
		
		return helloWorldService.readTextWithErrorTransactionPropagationRequired();
		
	}
	
}