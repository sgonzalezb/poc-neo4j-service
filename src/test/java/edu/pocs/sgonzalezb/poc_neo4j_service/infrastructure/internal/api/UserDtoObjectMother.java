package edu.pocs.sgonzalezb.poc_neo4j_service.infrastructure.internal.api;

import edu.pocs.sgonzalezb.poc_neo4j_service.infrastructure.internal.api.model.UserCompanyNameDto;
import edu.pocs.sgonzalezb.poc_neo4j_service.infrastructure.internal.api.model.UserDependentsDto;
import edu.pocs.sgonzalezb.poc_neo4j_service.infrastructure.internal.api.model.UserDto;

import java.util.List;

import static edu.pocs.sgonzalezb.poc_neo4j_service.domain.user.UserObjectMother.*;

public class UserDtoObjectMother {

    public static UserDto createAliceUserDto() {
        return new UserDto(ALICE_NAME,
                ALICE_MAIL,
                ALICE_HIRE_DATE,
                ALICE_ROLE);
    }

    public static UserDependentsDto createDavidUserDependentsDto() {
        return new UserDependentsDto(List.of(CHARLIE_NAME));
    }

    public static UserCompanyNameDto createAliceUserCompanyNameDto() {
        return new UserCompanyNameDto(ALICE_COMPANY);
    }
}
