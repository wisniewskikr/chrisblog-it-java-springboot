package com.example.jsons;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DisplayJson {
	
	private String message;
	
	@JsonProperty(value = "Client Port")
	private String displayPort;
	
	@JsonProperty(value = "Server Port")
	private String textPort;	
	
	public DisplayJson() {}

	public DisplayJson(String message, String displayPort, String textPort) {		
		this.message = message;
		this.displayPort = displayPort;
		this.textPort = textPort;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getDisplayPort() {
		return displayPort;
	}
	public void setDisplayPort(String displayPort) {
		this.displayPort = displayPort;
	}

	public String getTextPort() {
		return textPort;
	}
	public void setTextPort(String textPort) {
		this.textPort = textPort;
	} 	
	
}
