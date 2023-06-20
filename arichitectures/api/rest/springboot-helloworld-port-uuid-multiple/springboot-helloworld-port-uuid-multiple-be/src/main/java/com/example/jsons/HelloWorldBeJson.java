package com.example.jsons;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HelloWorldBeJson {
	
	private String message;
	@JsonProperty(value = "port BE")
	private String portBe;
	@JsonProperty(value = "uuid BE")
	private String uuidBe;
	
	public HelloWorldBeJson() {}

	public HelloWorldBeJson(String message, String portBe, String uuidBe) {
		this.message = message;
		this.portBe = portBe;
		this.uuidBe = uuidBe;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getPortBe() {
		return portBe;
	}
	public void setPortBe(String portBe) {
		this.portBe = portBe;
	}

	public String getUuidBe() {
		return uuidBe;
	}
	public void setUuidBe(String uuidBe) {
		this.uuidBe = uuidBe;
	}		
	
}
