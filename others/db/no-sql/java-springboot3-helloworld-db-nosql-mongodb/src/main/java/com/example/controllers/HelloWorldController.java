package com.example.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.dtos.HelloWorldDto;
import com.example.services.HelloWorldService;

@RestController
@AllArgsConstructor
@Slf4j
public class HelloWorldController {

	private HelloWorldService helloWorldService;

	@GetMapping
	public ResponseEntity<HelloWorldDto> helloWorld() {

		log.info("Called method HelloWorldController.helloWorld()");

		HelloWorldDto helloWorldDto = helloWorldService.findById("1");
		return ResponseEntity.ok(helloWorldDto);
		
	}
	
}