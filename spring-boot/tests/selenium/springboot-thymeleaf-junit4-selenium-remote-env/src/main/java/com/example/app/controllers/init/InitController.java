package com.example.app.controllers.init;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/")
public class InitController {

	@RequestMapping(method = RequestMethod.GET)
	public String init() {
		return "redirect:/input";		
	}
	
}