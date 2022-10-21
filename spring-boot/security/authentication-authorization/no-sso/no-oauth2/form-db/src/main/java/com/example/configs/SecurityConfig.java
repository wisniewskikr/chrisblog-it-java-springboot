package com.example.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.services.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	    
    private CustomUserDetailsService customUserDetailsService;
    
    @Autowired
    public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
		this.customUserDetailsService = customUserDetailsService;
	}

	@Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder() {
    	return new BCryptPasswordEncoder();
    }	

    @Override
    protected void configure(HttpSecurity http) throws Exception {
   	
    	http.csrf().disable();
    	http.headers().disable();
    	
    	http.authorizeRequests()
    		.antMatchers("/").hasRole("USER")
        .and()
        	.formLogin();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	
    	auth
			.userDetailsService(customUserDetailsService)
			.passwordEncoder(getBCryptPasswordEncoder());
    	        
    }    

}
