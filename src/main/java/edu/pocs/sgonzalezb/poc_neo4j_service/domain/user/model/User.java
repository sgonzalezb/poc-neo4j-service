package edu.pocs.sgonzalezb.poc_neo4j_service.domain.user.model;

import java.time.LocalDate;

public record User(String name, String email, LocalDate hireDate, String role) {
}
