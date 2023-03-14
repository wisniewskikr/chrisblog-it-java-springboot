package com.example.app.commands.greeting;

import javax.validation.constraints.NotBlank;

public class GreetingCommand {
		
	@NotBlank(message = "Name can not be blank.")
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