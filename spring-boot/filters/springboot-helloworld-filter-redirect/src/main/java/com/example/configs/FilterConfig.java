package com.example.configs;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.filters.HelloWorldFilter;

@Configuration
public class FilterConfig {
	
	@Bean
	public FilterRegistrationBean<HelloWorldFilter> setUpFilter(){
		
	    FilterRegistrationBean<HelloWorldFilter> registrationBean 
	      = new FilterRegistrationBean<>();
	        
	    registrationBean.setFilter(new HelloWorldFilter());
	    registrationBean.addUrlPatterns("/");
	    	        
	    return registrationBean; 
	    
	}


}
