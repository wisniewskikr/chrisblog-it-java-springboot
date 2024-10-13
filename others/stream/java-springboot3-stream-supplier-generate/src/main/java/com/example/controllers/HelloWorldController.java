package com.example.controllers;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping
	public ResponseEntity<Map<String, String>> helloWorld() {

        List<String> result = Stream
                                .generate(() -> "Hello World!")
								.limit(1)
                                .collect(Collectors.toList());

		Map<String, String> response = Collections.singletonMap("message", result.get(0));		
		return ResponseEntity.ok(response);		
		
	}
	
}