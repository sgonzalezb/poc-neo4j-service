package edu.pocs.sgonzalezb.poc_neo4j_service.infrastructure.internal.api.model;

import java.util.List;

public record UserDependentsDto(List<String> dependentsName) {
}
