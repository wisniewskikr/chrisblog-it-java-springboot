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
		String textAfterErrorWithoutTransaction = getTextAfterErrorWithoutTransaction();
		String textAfterErrorWithTransaction = getTextAfterErrorWithTransaction();
		
		return new HelloWorldJson(text, textAfterErrorWithoutTransaction, textAfterErrorWithTransaction);
		
	}
	
	private String getText() {
		
		try {
			helloWorldService.saveText("Hello", "World");
		} catch (Exception e) {
			System.err.println(e);
		}		
		
		return helloWorldService.readText();
		
	}
	
	private String getTextAfterErrorWithoutTransaction() {
		
		try {
			helloWorldService.saveTextWithErrorWithoutTransaction("Hello", "World");
		} catch (Exception e) {
			System.err.println(e);
		}		
		
		return helloWorldService.readTextWithErrorWithoutTransaction();
		
	}
	
	private String getTextAfterErrorWithTransaction() {
		
		try {
			helloWorldService.saveTextWithErrorWithTransaction("Hello", "World");
		} catch (Exception e) {
			System.err.println(e);
		}		
		
		return helloWorldService.readTextWithErrorWithTransaction();
		
	}
	
}