package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dtos.HelloWorldDto;
import com.example.services.HelloWorldService;

@RestController
public class CreateController {
	
	private HelloWorldService helloWorldService;

	@Autowired
	public CreateController(HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}

	@PostMapping(value="/create")
	public HelloWorldDto create(@RequestBody HelloWorldDto helloWorldDto) {		
		return helloWorldService.save(helloWorldDto);
	}

}	