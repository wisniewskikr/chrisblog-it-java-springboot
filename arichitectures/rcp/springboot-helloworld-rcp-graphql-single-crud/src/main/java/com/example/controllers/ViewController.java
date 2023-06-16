package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import com.example.dtos.UserDto;
import com.example.services.UserService;

@Controller
public class ViewController {
	
	private UserService userService;

	@Autowired
	public ViewController(UserService userService) {
		this.userService = userService;
	}

	@QueryMapping
	public UserDto view(@Argument Long id) {		
		return userService.findById(id);		
	}

}