package com.example.jsons;

public class HelloWorldBeJson {
	
	private String message;
	private String portBe;
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
