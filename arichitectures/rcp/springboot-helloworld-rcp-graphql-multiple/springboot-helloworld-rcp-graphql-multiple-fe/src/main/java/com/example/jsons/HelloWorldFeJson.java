package com.example.jsons;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HelloWorldFeJson {
	
	private String message;
	@JsonProperty(value = "port FE")
	private String portFe;
	@JsonProperty(value = "uuid FE")
	private String uuidFe;
	@JsonProperty(value = "port BE")
	private String portBe;
	@JsonProperty(value = "uuid BE")
	private String uuidBe;
	
	public HelloWorldFeJson() {}

	public HelloWorldFeJson(String message, String portFe, String uuidFe, String portBe, String uuidBe) {
		this.message = message;
		this.portFe = portFe;
		this.uuidFe = uuidFe;
		this.portBe = portBe;
		this.uuidBe = uuidBe;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getPortFe() {
		return portFe;
	}
	public void setPortFe(String portFe) {
		this.portFe = portFe;
	}

	public String getUuidFe() {
		return uuidFe;
	}
	public void setUuidFe(String uuidFe) {
		this.uuidFe = uuidFe;
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
