package com.example.dtos;

import com.example.records.HelloWorldRecord;

public class HelloWorldDto {
		
    private Long id; 
    private String text;    

	public HelloWorldDto(HelloWorldRecord entity) {
		this.id = entity.id();
		this.text = entity.text();
	}
	
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
