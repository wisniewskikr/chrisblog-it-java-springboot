package com.example.app.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.app.utils.EncryptionUtils;


@Service
public class EncryptionService {
	
	@Value("${encryption.password}")
    private String password;
	
    public String encryptText(String text) {
        return EncryptionUtils.encrypt(text, password) ;
    }

    public String decryptText(String text) {
        return EncryptionUtils.decrypt(text, password);
    }

}
