package com.example.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jsons.HelloWorldJson;

@RestController
public class HelloWorldController {

	@RequestMapping(value="/")
	public HelloWorldJson greeting() {		
		return new HelloWorldJson("Hello World!");	
	}
	
}