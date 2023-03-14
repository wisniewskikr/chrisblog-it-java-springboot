package com.example.components;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.entities.UserEntity;
import com.example.repositories.UserRepository;

@Component
public class InitComponent {
	
	@Value("${login}")
	private String login;
	@Value("${password}")
	private String password;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private UserRepository userRepository;
	
	public InitComponent(BCryptPasswordEncoder bCryptPasswordEncoder, UserRepository userRepository) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.userRepository = userRepository;
	}
	
	@PostConstruct
	private void init() {
		userRepository.save(new UserEntity(login, bCryptPasswordEncoder.encode(password), "USER"));
	}

}
