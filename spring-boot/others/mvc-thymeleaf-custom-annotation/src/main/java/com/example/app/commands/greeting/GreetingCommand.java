package com.example.app.commands.greeting;

import com.example.app.custom.annotations.Message;

public class GreetingCommand {
	
	@Message("Hello World")
	private String text;

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}	
	
}