package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.services.HelloWorldService;

@RestController
public class DeleteController {
	
	private HelloWorldService helloWorldService;

	@Autowired
	public DeleteController(HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}

	@DeleteMapping(value="/delete/{id}")
	public String delete(@PathVariable Long id) {		
		return helloWorldService.deleteById(id);
	}

}	