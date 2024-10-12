package com.example.controllers;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping
	public ResponseEntity<Map<String, String>> helloWorld(@RequestParam(name = "name", required = false) String name) {

		if (!Optional.ofNullable(name).isPresent()) {
			Map<String, String> response = Collections.singletonMap("message", "Name cannot be null!");		
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}

		Map<String, String> response = Collections.singletonMap("message", "Hello World " + name + "!");		
		return ResponseEntity.ok(response);		
		
	}
	
}