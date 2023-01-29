package com.example.jsons;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HelloWorldJson {
	
	@JsonProperty(value = "Message without any error")
	private String message;
	@JsonProperty(value = "Message after error with transaction propagation mandatory (partly saved - RIGHT)")
	private String messageErrorWithTransaction;

	public HelloWorldJson() {}

	public HelloWorldJson(String message, String messageErrorWithTransaction) {
		this.message = message;
		this.messageErrorWithTransaction = messageErrorWithTransaction;
	}	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessageErrorWithTransaction() {
		return messageErrorWithTransaction;
	}

	public void setMessageErrorWithTransaction(String messageErrorWithTransaction) {
		this.messageErrorWithTransaction = messageErrorWithTransaction;
	}	

}
