package edu.pocs.sgonzalezb.poc_neo4j_service.domain.user;

import edu.pocs.sgonzalezb.poc_neo4j_service.domain.user.model.User;

import java.time.LocalDate;

public class UserObjectMother {

    public static User createAliceUser() {
        return new User("Alice",
                "alice@techcorp.com",
                LocalDate.parse("2022-01-15"),
                "Engineer");
    }

    public static User createDavidUser() {
        return new User("David",
                "david@healthinc.com",
                LocalDate.parse("2018-08-30"),
                "Marketing Director");
    }
}
