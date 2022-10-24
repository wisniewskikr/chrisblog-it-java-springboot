package com.example.configs;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.filters.JwtFilter;

@Configuration
public class JwtConfig {
	
	@Value("${token.secret.key}")
	private String tokenSecretKey;
	
	@Bean
	public FilterRegistrationBean<JwtFilter> filterRegistrationBean() {
		
		FilterRegistrationBean<JwtFilter> filterRegistrationBean = new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(new JwtFilter(tokenSecretKey));
		filterRegistrationBean.setUrlPatterns(Collections.singleton("/"));
		return filterRegistrationBean;
		
	}

}
