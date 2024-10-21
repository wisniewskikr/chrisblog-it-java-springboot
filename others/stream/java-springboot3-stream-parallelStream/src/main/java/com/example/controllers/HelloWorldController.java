package com.example.controllers;

import java.util.Arrays;
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

		List<String> messages = Arrays.asList("Hello", "World");
                
        List<String> result = messages.parallelStream()
                                           .map(word -> {
                                                System.out.println(String.format("Word '%s' is handled by the Thread %s", word, Thread.currentThread().getName()));
                                                return word;
                                           })
                                           .collect(Collectors.toList());

		Map<String, String> response = Collections.singletonMap("message", result.get(0) + " " + result.get(1));		
		return ResponseEntity.ok(response);		
		
	}
	
}