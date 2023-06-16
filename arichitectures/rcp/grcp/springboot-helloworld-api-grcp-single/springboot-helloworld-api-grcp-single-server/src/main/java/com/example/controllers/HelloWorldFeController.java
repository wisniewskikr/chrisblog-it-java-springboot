package com.example.controllers;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.jsons.HelloWorldBeJson;
import com.example.jsons.HelloWorldFeJson;

import graphql.kickstart.spring.webclient.boot.GraphQLRequest;
import graphql.kickstart.spring.webclient.boot.GraphQLResponse;
import graphql.kickstart.spring.webclient.boot.GraphQLWebClient;

@Controller
public class HelloWorldFeController {
	
	Logger logger = LoggerFactory.getLogger(HelloWorldFeController.class);
	
	private Environment environment;
	
	private GraphQLWebClient graphQLWebClient;

	@Autowired
	public HelloWorldFeController(Environment environment, GraphQLWebClient graphQLWebClient) {
		this.environment = environment;
		this.graphQLWebClient = graphQLWebClient;
	}

	@QueryMapping
	public HelloWorldFeJson helloWorldFe() throws IOException {
		
		String portFe = environment.getProperty("local.server.port");
		String uuidFe = System.getProperty("uuid");		
		HelloWorldBeJson helloWorldBeJson = getHelloWorldBeJson(uuidFe);
		
		if (helloWorldBeJson == null) {
			return new HelloWorldFeJson("Problem with connection with BE application", portFe, uuidFe, null, null);
		}
				
		String message = helloWorldBeJson.getMessage();
		String portBe = helloWorldBeJson.getPortBe();
		String uuidBe = helloWorldBeJson.getUuidBe();		
		
		logger.info("Application FE was called with message: {}, port FE: {}, uuid FE: {}, port BE: {} and uuid BE: {}", message, portFe, uuidFe, portBe, uuidBe);
		
		return new HelloWorldFeJson(message, portFe, uuidFe, portBe, uuidBe);
		
	}
	
	private HelloWorldBeJson getHelloWorldBeJson(String uuidFe) throws IOException {

		GraphQLRequest request = GraphQLRequest.builder().resource("graphql/getHelloWorldBe.graphql").build();
        GraphQLResponse response = graphQLWebClient.post(request).block();
        return response.get("helloWorldBe", HelloWorldBeJson.class);
		
	}
	
}