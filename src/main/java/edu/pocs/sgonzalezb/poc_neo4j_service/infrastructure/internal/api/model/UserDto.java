package edu.pocs.sgonzalezb.poc_neo4j_service.infrastructure.internal.api.model;

import java.time.LocalDate;

public record UserDto(String name, String email, LocalDate hireDate, String role) {
}
