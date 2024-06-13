package edu.pocs.sgonzalezb.poc_neo4j_service.infrastructure.internal.api.controller;

import edu.pocs.sgonzalezb.poc_neo4j_service.PocNeo4jServiceApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = PocNeo4jServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserRestControllerTest {

    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();
    @LocalServerPort
    private int port;

    @Test
    public void given_valid_username_then_should_return_the_user() {

        final HttpEntity<String> entity = new HttpEntity<>(null, this.headers);

        final ResponseEntity<String> response = this.restTemplate.exchange(
                this.createURLWithPort("/users/David"),
                HttpMethod.GET, entity, String.class);

        final String expected = "{\"id\":\"Course1\",\"name\":\"Spring\",\"description\":\"10 Steps\"}";

        assertEquals("Error", expected, response.getBody());
    }

    private String createURLWithPort(final String uri) {
        return "http://localhost:" + this.port + uri;
    }
}