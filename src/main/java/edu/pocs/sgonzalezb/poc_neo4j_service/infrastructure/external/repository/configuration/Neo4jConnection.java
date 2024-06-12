package edu.pocs.sgonzalezb.poc_neo4j_service.infrastructure.external.repository.configuration;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@Profile("!test")
public class Neo4jConnection {

    @Value("${neo4j.datasources.uri}")
    private String uri;
    @Value("${neo4j.datasources.username}")
    private String user;
    @Value("${neo4j.datasources.password}")
    private String password;

    @Bean
    public Driver driver() {
        final var driver = GraphDatabase.driver(this.uri, AuthTokens.basic(this.user, this.password));
        driver.verifyConnectivity();

        return driver;
    }
}
