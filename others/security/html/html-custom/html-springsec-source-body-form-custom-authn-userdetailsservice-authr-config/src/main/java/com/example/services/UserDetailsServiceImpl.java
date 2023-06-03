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
	
	@Value(value = "${basic.username.user}")
    private String usernameUser;
	@Value(value = "${basic.password.user}")
    private String passwordUser;
	@Value(value = "${basic.username.admin}")
    private String usernameAdmin;
	@Value(value = "${basic.password.admin}")
    private String passwordAdmin;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (usernameUser.equals(username)) {
            return new UserEntity(usernameUser, new BCryptPasswordEncoder().encode(passwordUser), "USER");
        }

        if (usernameAdmin.equals(username)) {
            return new UserEntity(usernameAdmin, new BCryptPasswordEncoder().encode(passwordAdmin), "ADMIN");
        }

        throw new BadCredentialsException("(Invalid Login Details");
		
	}

}
