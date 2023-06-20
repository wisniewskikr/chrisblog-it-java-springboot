package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dtos.HelloWorldDto;
import com.example.services.HelloWorldService;

@RestController
public class EditController {
	
	private HelloWorldService helloWorldService;

	@Autowired
	public EditController(HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}

	@PutMapping(value="/edit/{id}")
	public HelloWorldDto edit(@PathVariable String id, @RequestBody HelloWorldDto helloWorldDto) {
		helloWorldDto.setId(id);		
		return helloWorldService.save(helloWorldDto);
	}

}	