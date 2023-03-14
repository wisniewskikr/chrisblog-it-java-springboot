package com.example.jsons;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DirtyReadJson {
	
	@JsonProperty(value = "Message before roll out (expected empty)")
	private String firstMessage;
	@JsonProperty(value = "Message after roll out (expected empty)")
	private String secondMessage;
	
	public DirtyReadJson() {}

	public DirtyReadJson(String firstMessage, String secondMessage) {
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
