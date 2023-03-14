package com.example.app.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.app.commands.EditCommand;
import com.example.app.entities.UserEntity;
import com.example.app.repositories.UserRepository;

@Controller
public class EditController {
	
	@Autowired
	private UserRepository userService;
	
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