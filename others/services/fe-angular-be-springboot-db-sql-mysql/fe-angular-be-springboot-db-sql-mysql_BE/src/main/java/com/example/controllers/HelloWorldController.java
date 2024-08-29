package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.dtos.HelloWorldDto;
import com.example.services.HelloWorldService;

@RestController
public class HelloWorldController {

	private HelloWorldService helloWorldService;

	@Autowired
	public HelloWorldController(HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}

	@CrossOrigin("http://localhost:4200/")
	@GetMapping("/message/{id}")
	public ResponseEntity<HelloWorldDto> helloWorld(@PathVariable Long id) {

		HelloWorldDto helloWorldDto = helloWorldService.findById(id);
		return ResponseEntity.ok(helloWorldDto);		
		
	}
	
}