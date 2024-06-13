package edu.pocs.sgonzalezb.poc_neo4j_service.infrastructure.internal.api.controller;

import edu.pocs.sgonzalezb.poc_neo4j_service.PocNeo4jServiceApplication;
import edu.pocs.sgonzalezb.poc_neo4j_service.infrastructure.configuration.Neo4jTestContainersConfig;
import edu.pocs.sgonzalezb.poc_neo4j_service.infrastructure.internal.api.model.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Map;

import static edu.pocs.sgonzalezb.poc_neo4j_service.infrastructure.internal.api.UserDtoObjectMother.createAliceUserDto;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
@SpringBootTest(classes = PocNeo4jServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserRestControllerTest extends Neo4jTestContainersConfig {

    private final TestRestTemplate restTemplate = new TestRestTemplate();
    private final HttpHeaders headers = new HttpHeaders();

    @LocalServerPort
    private int port;

    @Test
    public void given_valid_username_then_should_return_the_user() {

        final HttpEntity<String> entity = new HttpEntity<>(null, this.headers);

        final ResponseEntity<UserDto> response = this.restTemplate.exchange(
                this.createURLWithPort("/users/{name}"),
                HttpMethod.GET,
                entity,
                UserDto.class,
                Map.of("name", "Alice"));

        assertEquals(createAliceUserDto(), response.getBody());
    }

    @Test
    void given_valid_username_then_should_return_the_names_of_users_that_depend_on_it() {

    }

    @Test
    void given_valid_username_then_should_return_the_name_of_the_company_is_working() {

    }

    @Test
    void given_valid_username_then_should_return_the_department_name_which_belongs() {

    }

    @Test
    void given_valid_username_then_should_return_the_project_name_which_belongs() {

    }

    private String createURLWithPort(final String uri) {
        return "http://localhost:" + this.port + uri;
    }
}