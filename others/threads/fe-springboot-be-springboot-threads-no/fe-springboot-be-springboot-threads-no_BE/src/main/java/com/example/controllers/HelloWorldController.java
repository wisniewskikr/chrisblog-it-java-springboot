package com.example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping("/")
	public String helloWorld() throws InterruptedException {
		Thread.sleep(3000);
		return "Hello World!";			
	}
	
}