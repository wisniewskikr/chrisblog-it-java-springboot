package com.example.configs;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.filters.HelloWorldFilter1;
import com.example.filters.HelloWorldFilter2;

@Configuration
public class FilterConfig {
	
	@Bean
	public FilterRegistrationBean<HelloWorldFilter1> setUpFilter1(){
		
	    FilterRegistrationBean<HelloWorldFilter1> registrationBean 
	      = new FilterRegistrationBean<>();
	        
	    registrationBean.setFilter(new HelloWorldFilter1());
	    registrationBean.addUrlPatterns("/");
	    	        
	    return registrationBean; 
	    
	}
	
	@Bean
	public FilterRegistrationBean<HelloWorldFilter2> setUpFilter2(){
		
	    FilterRegistrationBean<HelloWorldFilter2> registrationBean 
	      = new FilterRegistrationBean<>();
	        
	    registrationBean.setFilter(new HelloWorldFilter2());
	    registrationBean.addUrlPatterns("/filter");
	    	        
	    return registrationBean; 
	    
	}

}
