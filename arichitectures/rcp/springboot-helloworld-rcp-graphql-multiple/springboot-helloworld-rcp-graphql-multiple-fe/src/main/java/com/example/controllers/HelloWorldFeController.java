package com.example.controllers;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.jsons.GraphqlRequestBodyJson;
import com.example.jsons.HelloWorldBeJson;
import com.example.jsons.HelloWorldFeJson;
import com.example.utils.GraphqlSchemaReaderUtil;

@Controller
public class HelloWorldFeController {
	
	Logger logger = LoggerFactory.getLogger(HelloWorldFeController.class);
	
	private Environment environment;
	
	private WebClient webClient;
	
	@Value("${helloworld.be.url}")
	private String helloWorldBeUrl;
	
	@Autowired
	public HelloWorldFeController(Environment environment, WebClient webClient) {
		this.environment = environment;
		this.webClient = webClient;
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

		GraphqlRequestBodyJson graphQLRequestBody = getGraphQLRequestBody();		
		HelloWorldBeJson helloWorldBeJson = null;
		
		try {
			
			helloWorldBeJson = this.webClient.post()
			        .uri(helloWorldBeUrl)
					.bodyValue(graphQLRequestBody)
			        .retrieve()
			        .bodyToMono(HelloWorldBeJson.class)
			        .block();
			
		} catch (Exception e) {
			logger.error("Problem with BE connection for FE application with UUID: " + uuidFe, e);
		}
		
		return helloWorldBeJson;
		
	}

	private GraphqlRequestBodyJson getGraphQLRequestBody() throws IOException {

		GraphqlRequestBodyJson graphQLRequestBody = new GraphqlRequestBodyJson();
		final String query = GraphqlSchemaReaderUtil.getSchemaFromFileName("getHelloWorldBe");
		graphQLRequestBody.setQuery(query);
		return graphQLRequestBody;

	}
	
}