package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.dtos.UserDto;
import com.example.services.UserService;

public class ViewController {
	
	private UserService userService;

	@Autowired
	public ViewController(UserService userService) {
		this.userService = userService;
	}

	public UserDto view(Long id) {		
		return userService.findById(id);		
	}

}