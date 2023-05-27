package com.example.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.entities.UserEntity;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Value("${basic.username.user}")
	private String userNameUser;
	@Value("${basic.password.user}")
	private String passwordUser;
    @Value("${basic.username.admin}")
	private String userNameAdmin;
	@Value("${basic.password.admin}")
	private String passwordAdmin;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (userNameUser.equals(username)) {
            return new UserEntity(userNameUser, new BCryptPasswordEncoder().encode(passwordUser), "USER");
        }

        if (userNameAdmin.equals(username)) {
            return new UserEntity(userNameAdmin, new BCryptPasswordEncoder().encode(passwordAdmin), "ADMIN");
        }

        throw new BadCredentialsException("(Invalid Login Details");
		
	}

}