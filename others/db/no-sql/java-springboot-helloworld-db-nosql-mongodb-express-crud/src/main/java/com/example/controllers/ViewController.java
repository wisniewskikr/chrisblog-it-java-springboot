package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.dtos.HelloWorldDto;
import com.example.services.HelloWorldService;

@RestController
public class ViewController {
	
	private HelloWorldService helloWorldService;

	@Autowired
	public ViewController(HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}

	@GetMapping(value="/view/{id}")
	public HelloWorldDto view(@PathVariable String id) {		
		return helloWorldService.read(id);
	}

}	