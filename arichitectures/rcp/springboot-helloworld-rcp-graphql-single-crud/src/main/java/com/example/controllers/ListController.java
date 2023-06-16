package com.example.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import com.example.dtos.UserDto;
import com.example.services.UserService;

@Controller
public class ListController {
	
	private UserService userService;

	@Autowired
	public ListController(UserService userService) {
		this.userService = userService;
	}

	@QueryMapping
	public List<UserDto> list() {		
		return userService.findAll();
	}

}