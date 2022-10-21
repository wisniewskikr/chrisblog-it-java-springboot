package com.example.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.entities.TokenEntity;
import com.example.entities.UserEntity;
import com.example.repositories.TokenRepository;
import com.example.repositories.UserRepository;

@Service
public class UserService {
	
	@Value("${email.from}")
	private String from;
	@Value("${email.subject}")
	private String subject;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private UserRepository userRepository;
	private TokenRepository tokenRepository;
	private EmailSenderService emailSenderService;
	
	@Autowired
	public UserService(BCryptPasswordEncoder bCryptPasswordEncoder, UserRepository userRepository,
			TokenRepository tokenRepository, EmailSenderService emailSenderService) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.userRepository = userRepository;
		this.tokenRepository = tokenRepository;
		this.emailSenderService = emailSenderService;
	}		

	public void registrationBeforeConfirmation(String email, String password) {	
		
		UserEntity user = userRepository.save(new UserEntity(email, bCryptPasswordEncoder.encode(password), "USER"));
		TokenEntity token = tokenRepository.save(new TokenEntity(UUID.randomUUID().toString(), user));
		String emailContent = "http://localhost:8080/confirm?token=" + token.getValue();
		emailSenderService.sendEmailText(from, user.getEmail(), subject, emailContent);
		
	}	

	public void registrationAfterConfirmation(String value) {	
		
		TokenEntity token = tokenRepository.findByValue(value);
		UserEntity user = token.getUser();
		user.setEnabled(true);
		userRepository.save(user);
		tokenRepository.delete(token);
		
	}

}
