package com.example.controllers;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping
	public ResponseEntity<Map<String, String>> helloWorld() {

		List<List<String>> messages = Arrays.asList(
            Arrays.asList("Hello"),
            Arrays.asList("World")
        );
                
        List<String> result = messages.stream()
                                           .flatMap(Collection::stream)
                                           .collect(Collectors.toList());

		Map<String, String> response = Collections.singletonMap("message", result.get(0) + " " + result.get(1));		
		return ResponseEntity.ok(response);		
		
	}
	
}