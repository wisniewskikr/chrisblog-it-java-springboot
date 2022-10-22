package com.example.app.commands.greeting;

import com.example.app.custom.annotations.ValidName;

public class GreetingCommand {
		
	@ValidName(name = "Chris", message = "Only Chris is valid name")
	private String name;
	private String message;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}	
	
}