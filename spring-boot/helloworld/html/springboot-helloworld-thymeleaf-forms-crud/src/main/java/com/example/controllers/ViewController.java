package com.example.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.commands.ViewCommand;
import com.example.services.UserService;

@Controller
public class ViewController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/view")
	public String displayPage(@ModelAttribute("command")ViewCommand command,
			HttpSession session) {
		
		Long id = (Long)session.getAttribute("selectedUserId");
		command.setName(userService.findById(id).get().getName());
		return "view";
		
	}

}