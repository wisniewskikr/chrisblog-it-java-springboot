package com.example.jsons;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HelloWorldJson {
	
	@JsonProperty(value = "Message without any error")
	private String message;
	@JsonProperty(value = "Message after error without transaction (partly saved - WRONG)")
	private String messageErrorWithoutTransaction;
	@JsonProperty(value = "Message after error with transaction (not saved - RIGHT)")
	private String messageErrorWithTransaction;

	public HelloWorldJson() {}

	public HelloWorldJson(String message, String messageErrorWithoutTransaction, String messageErrorWithTransaction) {
		this.message = message;
		this.messageErrorWithoutTransaction = messageErrorWithoutTransaction;
		this.messageErrorWithTransaction = messageErrorWithTransaction;
	}	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessageErrorWithoutTransaction() {
		return messageErrorWithoutTransaction;
	}

	public void setMessageErrorWithoutTransaction(String messageErrorWithoutTransaction) {
		this.messageErrorWithoutTransaction = messageErrorWithoutTransaction;
	}

	public String getMessageErrorWithTransaction() {
		return messageErrorWithTransaction;
	}

	public void setMessageErrorWithTransaction(String messageErrorWithTransaction) {
		this.messageErrorWithTransaction = messageErrorWithTransaction;
	}	

}
