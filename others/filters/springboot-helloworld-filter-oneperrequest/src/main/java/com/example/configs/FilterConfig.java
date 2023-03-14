package com.example.configs;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.filters.HelloWorldFilter;

@Configuration
public class FilterConfig {
	
	@Bean
    public Filter helloWorldFilter() {
        return new HelloWorldFilter();
    }

}
