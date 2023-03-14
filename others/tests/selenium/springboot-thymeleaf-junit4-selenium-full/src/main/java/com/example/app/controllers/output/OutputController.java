package com.example.app.controllers.output;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.app.commands.output.OutputCommand;


@Controller
@RequestMapping(value="/output")
public class OutputController {

	@RequestMapping(method = RequestMethod.GET)
	public String display(
			@ModelAttribute("command") OutputCommand command,
			HttpSession session) {
		
		command.setName((String)session.getAttribute("name"));
		return "output/output";		
		
	}
	
}