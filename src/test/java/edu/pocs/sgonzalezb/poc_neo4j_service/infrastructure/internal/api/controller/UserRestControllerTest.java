package edu.pocs.sgonzalezb.poc_neo4j_service.infrastructure.internal.api.controller;

import edu.pocs.sgonzalezb.poc_neo4j_service.PocNeo4jServiceApplication;
import edu.pocs.sgonzalezb.poc_neo4j_service.infrastructure.configuration.Neo4jTestContainersConfig;
import edu.pocs.sgonzalezb.poc_neo4j_service.infrastructure.internal.api.model.UserCompanyNameDto;
import edu.pocs.sgonzalezb.poc_neo4j_service.infrastructure.internal.api.model.UserDependentsDto;
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

import static edu.pocs.sgonzalezb.poc_neo4j_service.domain.user.UserObjectMother.ALICE_NAME;
import static edu.pocs.sgonzalezb.poc_neo4j_service.domain.user.UserObjectMother.DAVID_NAME;
import static edu.pocs.sgonzalezb.poc_neo4j_service.infrastructure.internal.api.UserDtoObjectMother.*;
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
                Map.of("name", ALICE_NAME));

        assertEquals(createAliceUserDto(), response.getBody());
    }

    @Test
    void given_valid_username_then_should_return_the_names_of_users_that_depend_on_it() {

        final HttpEntity<String> entity = new HttpEntity<>(null, this.headers);

        final ResponseEntity<UserDependentsDto> response = this.restTemplate.exchange(
                this.createURLWithPort("/users/{name}/dependents/name"),
                HttpMethod.GET,
                entity,
                UserDependentsDto.class,
                Map.of("name", DAVID_NAME));

        assertEquals(createDavidUserDependentsDto(), response.getBody());
    }

    @Test
    void given_valid_username_then_should_return_the_name_of_the_company_is_working() {
        final HttpEntity<String> entity = new HttpEntity<>(null, this.headers);

        final ResponseEntity<UserCompanyNameDto> response = this.restTemplate.exchange(
                this.createURLWithPort("/users/{name}/company/name"),
                HttpMethod.GET,
                entity,
                UserCompanyNameDto.class,
                Map.of("name", ALICE_NAME));

        assertEquals(createAliceUserCompanyNameDto(), response.getBody());
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