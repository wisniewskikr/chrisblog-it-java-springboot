package com.example.jsons;

public class HelloWorldJson {
	
	private String message;
	private String uuid;
	
	public HelloWorldJson() {}

	public HelloWorldJson(String message, String uuid) {		
		this.message = message;
		this.uuid = uuid;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}	
	
}
