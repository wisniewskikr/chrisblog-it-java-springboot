package com.example.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.commands.EditCommand;
import com.example.entities.UserEntity;
import com.example.services.UserService;

@Controller
public class EditController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/edit")
	public String displayPage(@ModelAttribute("command")EditCommand command,
			HttpSession session) {
		
		Long id = (Long)session.getAttribute("selectedUserId");		
		command.setName(userService.findById(id).get().getName());
		return "edit";
		
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String handleButtonEdit(@ModelAttribute("command")EditCommand command,
			HttpSession session) {
		
		Long id = (Long)session.getAttribute("selectedUserId");
		userService.save(new UserEntity(id, command.getName()));
		return "redirect:/list";
		
	}

}