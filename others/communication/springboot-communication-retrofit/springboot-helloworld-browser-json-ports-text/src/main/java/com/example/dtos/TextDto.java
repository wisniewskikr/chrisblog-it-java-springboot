package com.example.dtos;

public class TextDto {
	
	private String message;
	private String port;
	
	public TextDto() {}

	public TextDto(String message, String port) {		
		this.message = message;
		this.port = port;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}	
	
}
