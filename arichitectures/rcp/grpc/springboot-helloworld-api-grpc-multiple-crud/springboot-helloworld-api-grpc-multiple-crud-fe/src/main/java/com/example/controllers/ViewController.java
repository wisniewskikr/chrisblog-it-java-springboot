package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.dtos.UserDto;
import com.example.services.UserService;

@RestController
public class ViewController {
	
	private UserService userService;

	@Autowired
	public ViewController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/view/{id}")
	public UserDto view(@PathVariable Long id) {		
		return userService.findById(id);		
	}

}