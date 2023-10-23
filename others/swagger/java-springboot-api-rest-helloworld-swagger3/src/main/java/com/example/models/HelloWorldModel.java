package com.example.models;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Model of object HelloWorldModel")
public class HelloWorldModel {
	
	@Schema(description = "Unique Id of object HelloWorldModel")
    private Long id; 
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
