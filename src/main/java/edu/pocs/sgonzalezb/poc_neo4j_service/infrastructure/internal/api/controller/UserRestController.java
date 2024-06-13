package edu.pocs.sgonzalezb.poc_neo4j_service.infrastructure.internal.api.controller;


import edu.pocs.sgonzalezb.poc_neo4j_service.infrastructure.internal.api.model.UserDto;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserRestController {


    @GetMapping("/{name}")
    public UserDto findUserByUserName(
            @PathParam("name") final String name) {
        return null;
    }
}
