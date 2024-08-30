package edu.pocs.sgonzalezb.poc_neo4j_service.infrastructure.external.repository;

import edu.pocs.sgonzalezb.poc_neo4j_service.domain.user.model.User;

import java.time.LocalDate;
import java.util.Map;

//todo: change for MapStruct
public interface UserMapper {

    String NAME_FIELD = "name";
    String EMAIL_FIELD = "email";
    String HIRE_DATE_FIELD = "hire_date";
    String ROLE_FIELD = "role";

    static User fromMap(final Map<String, Object> map) {

        return new User(map.get(NAME_FIELD).toString(),
                map.get(EMAIL_FIELD).toString(),
                LocalDate.parse(map.get(HIRE_DATE_FIELD).toString()),
                map.get(ROLE_FIELD).toString());
    }
}
