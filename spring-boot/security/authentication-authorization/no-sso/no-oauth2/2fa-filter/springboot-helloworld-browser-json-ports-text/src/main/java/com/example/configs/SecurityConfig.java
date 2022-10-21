package com.example.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.example.filters.CustomBasicAuthenticationFilter;
import com.example.filters.CustomCodeAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Value("${basic.username}")
	private String username;
	@Value("${basic.password}")
	private String password;
	@Value("${code}")
	private String code;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
   	
    	http
    		.addFilterBefore(new CustomCodeAuthenticationFilter(code, "/"), BasicAuthenticationFilter.class)	
    		.addFilterAfter(new CustomBasicAuthenticationFilter(username, password, "/"), BasicAuthenticationFilter.class);    		

    }

}
