package com.example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping("/{name}")
	public String helloWorld(@PathVariable("name") String name) throws InterruptedException {
		Thread.sleep(3000);
		return "Hello World " + name + "!";			
	}
	
}