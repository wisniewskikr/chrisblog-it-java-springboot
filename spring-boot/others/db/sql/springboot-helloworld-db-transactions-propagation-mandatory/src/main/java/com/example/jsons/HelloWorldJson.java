package com.example.jsons;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HelloWorldJson {
	
	@JsonProperty(value = "description")
	private String description;
	@JsonProperty(value = "sentence")
	private String sentence;

	public HelloWorldJson() {}

	public HelloWorldJson(String description, String sentence) {
		this.description = description;
		this.sentence = sentence;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSentence() {
		return sentence;
	}

	public void setSentence(String sentence) {
		this.sentence = sentence;
	}

}
