package com.example.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping(value="/")
	public String helloWorld1() {		
		return "Hello World!";		
	}
	
	@RequestMapping(value="/filter")
	public String helloWorld2() {		
		return "Hello World!";		
	}
	
}