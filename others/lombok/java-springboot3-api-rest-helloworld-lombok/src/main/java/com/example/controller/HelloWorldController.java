package com.example.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.HelloWorldService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class HelloWorldController {

	private final HelloWorldService helloWorldService;

	@GetMapping
	public ResponseEntity<Map<String, String>> helloWorld() {

		Map<String, String> response = helloWorldService.getResponse();		
		return ResponseEntity.ok(response);		
		
	}
	
}