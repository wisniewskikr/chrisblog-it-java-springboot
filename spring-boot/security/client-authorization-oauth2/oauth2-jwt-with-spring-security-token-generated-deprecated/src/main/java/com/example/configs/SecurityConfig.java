package com.example.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.example.filters.JwtFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Value("${token.secret.key}")
	private String tokenSecretKey;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
   	
    	http.authorizeRequests()
			.antMatchers("/").hasRole("USER");
    	
    	http.addFilter(new JwtFilter(tokenSecretKey, authenticationManager()));

    }


    

}
