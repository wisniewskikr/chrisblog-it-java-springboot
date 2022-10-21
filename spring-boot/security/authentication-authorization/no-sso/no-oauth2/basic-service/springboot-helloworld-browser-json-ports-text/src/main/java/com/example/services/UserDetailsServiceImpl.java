package com.example.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.entities.UserEntity;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Value("${basic.username}")
	private String basicUserName;
	@Value("${basic.password}")
	private String basicPassword;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return new UserEntity(basicUserName, new BCryptPasswordEncoder().encode(basicPassword), "USER");
	}

}
