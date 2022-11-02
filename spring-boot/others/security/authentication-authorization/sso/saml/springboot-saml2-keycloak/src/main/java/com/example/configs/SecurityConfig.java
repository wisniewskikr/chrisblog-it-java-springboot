package com.example.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	protected void configure(HttpSecurity http) throws Exception {
	
		http
			.authorizeRequests(authorize -> authorize
					.antMatchers("/").permitAll()
					.antMatchers("/user").hasAnyRole("USER", "ADMIN")
					.antMatchers("/admin").hasRole("ADMIN")
			)
			.saml2Login(Customizer.withDefaults())
			.logout().logoutUrl("/logout")
		.and()
			.exceptionHandling().accessDeniedPage("/access-denied");
		
	}

}
