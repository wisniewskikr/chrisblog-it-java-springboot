package com.example.configs;

import org.springframework.context.annotation.Configuration;

import java.util.List;

import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class Swagger3Config {

    @Bean
    public OpenAPI myOpenAPI() {

        Server server = new Server();
        server.setUrl("http://localhost:8080");
        server.setDescription("Server URL in the environment");

        Contact contact = new Contact();
        contact.setEmail("helloworld@gmail.com");
        contact.setName("Hello World");
        contact.setUrl("https://helloworld.com");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
            .title("Messages API")
            .version("1.0")
            .contact(contact)
            .description("This API exposes endpoints to manage messages.")
            .termsOfService("http://helloworld.com")
            .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(server));

    }
    
}
