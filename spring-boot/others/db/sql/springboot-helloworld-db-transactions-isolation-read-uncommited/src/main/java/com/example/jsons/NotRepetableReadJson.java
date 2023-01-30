package com.example.jsons;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NotRepetableReadJson {
	
	@JsonProperty(value = "Message before update (expected empty)")
	private String firstMessage;
	@JsonProperty(value = "Message after update (expected empty)")
	private String secondMessage;
	
	public NotRepetableReadJson() {}

	public NotRepetableReadJson(String firstMessage, String secondMessage) {
		super();
		this.firstMessage = firstMessage;
		this.secondMessage = secondMessage;
	}

	public String getFirstMessage() {
		return firstMessage;
	}

	public void setFirstMessage(String firstMessage) {
		this.firstMessage = firstMessage;
	}

	public String getSecondMessage() {
		return secondMessage;
	}

	public void setSecondMessage(String secondMessage) {
		this.secondMessage = secondMessage;
	}	

}
