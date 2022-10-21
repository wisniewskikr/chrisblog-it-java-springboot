package com.example.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.configs.FeignConfig;
import com.example.jsons.TextJson;

@FeignClient(name = "${text.service.name}", 
	url = "${text.service.url}",
	configuration = FeignConfig.class)
public interface TextFeignClient {
	
	@GetMapping(value="/")
	public TextJson provideText();

}
