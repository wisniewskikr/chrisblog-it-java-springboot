package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jsons.TextJson;

@RestController
public class TextController {
	
private Environment environment;	
	
	@Autowired
	public TextController(Environment environment) {
		this.environment = environment;
	}

	@RequestMapping(value="/")
	public List<TextJson> greeting() {
		
		List<TextJson> list = new ArrayList<TextJson>();
		
		String port = environment.getProperty("local.server.port");
		list.add(new TextJson("Hello World 1!", port));
		list.add(new TextJson("Hello World 2!", port));
		list.add(new TextJson("Hello World 3!", port));
		
		return list;
		
	}
	
}