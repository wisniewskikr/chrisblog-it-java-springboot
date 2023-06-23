package com.rosariob.crud.neo4j.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "application")
@Configuration
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ApplicationProperties {
    private String database;
}
