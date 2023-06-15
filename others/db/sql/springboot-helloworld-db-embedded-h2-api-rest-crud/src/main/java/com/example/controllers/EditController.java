package com.example.controllers;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.commands.EditCommand;
import com.example.dtos.UserDto;
import com.example.services.UserService;

@Controller
public class EditController {
	
	private UserService userService;

	@Autowired
	public EditController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value="/edit")
	public String displayPage(@ModelAttribute("command")EditCommand command,
			HttpSession session) {
		
		Long id = (Long)session.getAttribute("selectedUserId");		
		command.setName(userService.findById(id).getName());
		return "edit";
		
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String handleButtonEdit(@ModelAttribute("command")EditCommand command,
			HttpSession session) {
		
		Long id = (Long)session.getAttribute("selectedUserId");
		userService.save(new UserDto(id, command.getName()));
		return "redirect:/list";
		
	}

}