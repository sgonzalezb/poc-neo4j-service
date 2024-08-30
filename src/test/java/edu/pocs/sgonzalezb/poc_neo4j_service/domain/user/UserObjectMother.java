package edu.pocs.sgonzalezb.poc_neo4j_service.domain.user;

import edu.pocs.sgonzalezb.poc_neo4j_service.domain.user.model.User;

import java.time.LocalDate;

public class UserObjectMother {

    public static final String CHARLIE_NAME = "Charlie";
    public static final String CHARLIE_DEPARTMENT_NAME = "Marketing";
    public static final String CHARLIE_PROJECT_NAME = "Project Beta";

    public static final String DAVID_NAME = "David";
    public static final String DAVID_MAIL = "david@healthinc.com";
    public static final LocalDate DAVID_HIRE_DATE = LocalDate.parse("2018-08-30");
    public static final String DAVID_ROLE = "Marketing Director";

    public static final String ALICE_NAME = "Alice";
    public static final String ALICE_MAIL = "alice@techcorp.com";
    public static final LocalDate ALICE_HIRE_DATE = LocalDate.parse("2022-01-15");
    public static final String ALICE_ROLE = "Engineer";
    public static final String ALICE_COMPANY = "TechCorp";

    public static User createAliceUser() {
        return new User(ALICE_NAME,
                ALICE_MAIL,
                ALICE_HIRE_DATE,
                ALICE_ROLE);
    }

    public static User createDavidUser() {
        return new User(DAVID_NAME,
                DAVID_MAIL,
                DAVID_HIRE_DATE,
                DAVID_ROLE);
    }
}
