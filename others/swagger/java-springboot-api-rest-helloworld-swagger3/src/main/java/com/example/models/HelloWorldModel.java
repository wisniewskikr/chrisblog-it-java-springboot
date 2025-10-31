package com.example.models;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Model of Message")
public class HelloWorldModel {
	
	@Schema(description = "Unique Id of Message", example = "1")
    private Long id;
	@Schema(description = "Text of Message", example = "Hello World!")
    private String text;    
	
	public HelloWorldModel() {}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

}
