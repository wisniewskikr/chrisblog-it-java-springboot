package com.example.providers;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationProviderImpl implements AuthenticationProvider {
	
	@Value(value = "${basic.username.user}")
    private String userNameUser;
    @Value(value = "${basic.password.user}")
    private String passwordUser;
    @Value(value = "${basic.username.admin}")
    private String userNameAdmin;
    @Value(value = "${basic.password.admin}")
    private String passwordAdmin;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String username = authentication.getName();
        String password = authentication.getCredentials().toString();
		
		if (userNameUser.equals(username) && passwordUser.equals(password)) {
			return new UsernamePasswordAuthenticationToken(username, password, Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));
		}
        
        if (userNameAdmin.equals(username) && passwordAdmin.equals(password)) {
			return new UsernamePasswordAuthenticationToken(username, password, Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));
		}

        throw new BadCredentialsException("(Invalid Login Details");
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
}
