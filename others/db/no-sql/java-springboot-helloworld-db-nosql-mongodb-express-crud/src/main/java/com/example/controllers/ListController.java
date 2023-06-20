package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dtos.HelloWorldDto;
import com.example.services.HelloWorldService;

@RestController
public class ListController {
	
	private HelloWorldService helloWorldService;

	@Autowired
	public ListController(HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}

	@GetMapping(value="/list")
	public List<HelloWorldDto> list() {		
		return helloWorldService.findAll();
	}

}	