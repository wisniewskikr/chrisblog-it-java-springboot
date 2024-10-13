package com.example.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping
	public ResponseEntity<Map<String, String>> helloWorld() {

		List<String> result = new ArrayList<>();

		List<String> messages = Arrays.asList("Hello World!");
		                
        messages.stream()
                    .forEach(result::add);

		Map<String, String> response = Collections.singletonMap("message", result.get(0));		
		return ResponseEntity.ok(response);		
		
	}
	
}