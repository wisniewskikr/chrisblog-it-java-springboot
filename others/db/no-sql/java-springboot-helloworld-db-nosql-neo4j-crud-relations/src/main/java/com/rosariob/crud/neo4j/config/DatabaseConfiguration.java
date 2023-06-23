package com.rosariob.crud.neo4j.config;

import org.neo4j.cypherdsl.core.renderer.Dialect;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.AbstractNeo4jConfig;
import org.springframework.data.neo4j.core.DatabaseSelectionProvider;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com/rosariob/crud/neo4j/config, com/rosariob/crud/neo4j/config/service" })
@EnableNeo4jRepositories(basePackages = "com/rosariob/crud/neo4j/repository")
@EnableTransactionManagement
public class DatabaseConfiguration extends AbstractNeo4jConfig {

    private Neo4jProperties neo4jProperties;

    private ApplicationProperties applicationProperties;

    @Autowired
    public DatabaseConfiguration(Neo4jProperties neo4jProperties, ApplicationProperties applicationProperties) {
        this.neo4jProperties = neo4jProperties;
        this.applicationProperties = applicationProperties;
    }

    @Override
    @Bean
    public Driver driver() {
        Neo4jProperties.Authentication authentication = neo4jProperties.getAuthentication();
        return  GraphDatabase.driver(neo4jProperties.getUri(),
                AuthTokens.basic(authentication.getUsername(), authentication.getPassword()));
    }

    @Override @Bean
    protected DatabaseSelectionProvider databaseSelectionProvider() {
        return DatabaseSelectionProvider.createStaticDatabaseSelectionProvider(applicationProperties.getDatabase());
    }

    @Bean
    public org.neo4j.cypherdsl.core.renderer.Configuration cypherDslConfiguration() {
        return org.neo4j.cypherdsl.core.renderer.Configuration.newConfig()
            .withDialect(Dialect.NEO4J_5)
            .build();
    } 
}
