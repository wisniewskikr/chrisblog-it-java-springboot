package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.commands.HelloWorldCommand;
import com.example.jsons.TextJson;


@Controller
@RequestMapping(value="/")
public class HelloWorldController {
	
	private WebClient webClient;
	
	@Value("${text.service.url}")
	private String textServiceUrl;
	
	@Autowired
	public HelloWorldController(WebClient webClient) {
		this.webClient = webClient;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String display(@ModelAttribute("command") HelloWorldCommand command) {
		return "helloworld/helloworld";		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String handleSubmit(
			@ModelAttribute("command") HelloWorldCommand command) {
		
		TextJson textJson = this.webClient.get()
	            .uri(textServiceUrl)
	            .retrieve()
	            .bodyToMono(TextJson.class)
	            .block();
				
		command.setMessage(String.format("%s %s!", textJson.getMessage(), command.getName()));
		command.setName(null);
		return "helloworld/helloworld";
		
	}
	
}