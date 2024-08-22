package com.example.controllers;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.HelloWorldEntity;
import com.example.services.HelloWorldService;

@RestController
public class HelloWorldController {

	private HelloWorldService helloWorldService;

	@Autowired
	public HelloWorldController(HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}

	@GetMapping
	public ResponseEntity<Map<String, String>> helloWorld() {

		HelloWorldEntity helloWorldEntity = helloWorldService.findById(1L);
		Map<String, String> response = Collections.singletonMap("message", helloWorldEntity.getText());		
		return ResponseEntity.ok(response);		
		
	}
	
}