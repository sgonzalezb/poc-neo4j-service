package edu.pocs.sgonzalezb.poc_neo4j_service.domain.user;

import edu.pocs.sgonzalezb.poc_neo4j_service.domain.user.model.User;

import java.time.LocalDate;

public class UserObjectMother {

    private static final String ALICE_NAME = "Alice";
    private static final String ALICE_EMAIL = "alice@techcorp.com";
    private static final LocalDate ALICE_HIRE_DATE = LocalDate.parse("2022-01-15");
    private static final String ALICE_ROLE = "Engineer";

    public static User createAliceUser() {
        return new User(ALICE_NAME, ALICE_EMAIL, ALICE_HIRE_DATE, ALICE_ROLE);
    }
}
