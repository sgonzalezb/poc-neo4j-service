package edu.pocs.sgonzalezb.poc_neo4j_service.infrastructure.internal.api;

import edu.pocs.sgonzalezb.poc_neo4j_service.infrastructure.internal.api.model.UserDependentsDto;
import edu.pocs.sgonzalezb.poc_neo4j_service.infrastructure.internal.api.model.UserDto;

import java.time.LocalDate;
import java.util.List;

public class UserDtoObjectMother {

    static final String CHARLIE_NAME = "Charlie";
    static final String CHARLIE_DEPARTMENT_NAME = "Marketing";
    static final String CHARLIE_PROJECT_NAME = "Project Beta";

    static final String DAVID_NAME = "David";
    static final String DAVID_MAIL = "david@healthinc.com";
    static final LocalDate DAVID_HIRE_DATE = LocalDate.parse("2018-08-30");
    static final String DAVID_ROLE = "Marketing Director";

    static final String ALICE_NAME = "Alice";
    static final String ALICE_MAIL = "alice@techcorp.com";
    static final LocalDate ALICE_HIRE_DATE = LocalDate.parse("2022-01-15");
    static final String ALICE_ROLE = "Engineer";
    static final String ALICE_COMPANY = "TechCorp";

    public static UserDto createAliceUserDto() {
        return new UserDto(ALICE_NAME,
                ALICE_MAIL,
                ALICE_HIRE_DATE,
                ALICE_ROLE);
    }

    public static UserDependentsDto createDavidUserDependentsDto() {
        return new UserDependentsDto(List.of(CHARLIE_NAME));
    }
}
