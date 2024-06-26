package com.example.controllers;

import java.util.Collections;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

	@GetMapping("/admin")
	public ResponseEntity<Map<String, String>> helloWorld() {

		Map<String, String> response = Collections.singletonMap("message", "Hello World, Admin!");		
		return ResponseEntity.ok(response);		
		
	}
	
}