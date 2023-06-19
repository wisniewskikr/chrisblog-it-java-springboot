package com.example.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.dtos.UserDto;
import com.example.services.UserService;

public class ListController {
	
	private UserService userService;

	@Autowired
	public ListController(UserService userService) {
		this.userService = userService;
	}

	public List<UserDto> list() {		
		return userService.findAll();
	}

}