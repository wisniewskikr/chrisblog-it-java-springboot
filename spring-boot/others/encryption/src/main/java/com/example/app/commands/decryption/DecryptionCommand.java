package com.example.app.commands.decryption;

public class DecryptionCommand {
		
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