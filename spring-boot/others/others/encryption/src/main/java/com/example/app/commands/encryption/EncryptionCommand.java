package com.example.app.commands.encryption;

public class EncryptionCommand {
		
	private String text;
	private String encryptedText;
		
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public String getEncryptedText() {
		return encryptedText;
	}
	public void setEncryptedText(String encryptedText) {
		this.encryptedText = encryptedText;
	}	
	
}