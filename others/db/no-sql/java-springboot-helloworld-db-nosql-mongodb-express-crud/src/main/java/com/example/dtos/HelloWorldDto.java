package com.example.dtos;

import com.example.documents.HelloWorldDoc;

public class HelloWorldDto {
		
    private String id; 
    private String text;    
	
	public HelloWorldDto() {}

	public HelloWorldDto(HelloWorldDoc doc) {
		this.id = doc.getId();
		this.text = doc.getText();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

}
