package com.example.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.dtos.UserDto;
import com.example.services.UserService;

@RestController
public class ListController {
	
	private UserService userService;

	@Autowired
	public ListController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/list")
	public List<UserDto> list() {		
		return userService.findAll();
	}

}