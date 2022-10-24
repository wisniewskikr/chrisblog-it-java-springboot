package com.example.app.controllers.input;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.app.commands.input.InputCommand;


@Controller
@RequestMapping(value="/input")
public class InputController {

	@RequestMapping(method = RequestMethod.GET)
	public String display(@ModelAttribute("command") InputCommand command) {
		return "input/input";		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String handleSubmit(
			@ModelAttribute("command") InputCommand command,
			HttpSession session) {
				
		session.setAttribute("name", command.getName());
		return "redirect:/output";
		
	}
	
}