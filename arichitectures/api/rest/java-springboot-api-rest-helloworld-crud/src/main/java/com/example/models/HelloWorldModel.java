package com.example.models;


public class HelloWorldModel {
		
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
