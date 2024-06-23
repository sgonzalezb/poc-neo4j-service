package edu.pocs.sgonzalezb.poc_neo4j_service.infrastructure.external;

import edu.pocs.sgonzalezb.poc_neo4j_service.domain.user.repository.UserRepository;
import edu.pocs.sgonzalezb.poc_neo4j_service.infrastructure.configuration.Neo4jTestContainersConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static edu.pocs.sgonzalezb.poc_neo4j_service.domain.user.UserObjectMother.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class UserRepositoryImplTest extends Neo4jTestContainersConfig {

    @Autowired
    private UserRepository userRepository;

    @Test
    void when_username_is_passed_and_exists_should_return_the_name_of_the_user() {

        final String userName = this.userRepository.findUserByName(ALICE_NAME).name();

        assertEquals(ALICE_NAME, userName);
    }


    @Test
    void when_username_is_passed_and_exists_should_return_the_names_of_users_that_depend_on_it() {

        final List<String> dependentsNamesByUserName = this.userRepository.findDependentsNamesByUserName(DAVID_NAME);

        assertEquals(List.of(CHARLIE_NAME), dependentsNamesByUserName);
    }

    @Test
    void when_username_is_passed_and_exists_should_return_the_name_of_the_company_is_working() {

        final String corporationName = this.userRepository.findCompanyNameByUserName(ALICE_NAME);

        assertEquals(ALICE_COMPANY, corporationName);
    }

    @Test
    void when_username_is_passed_and_exists_should_return_the_department_name_which_belongs() {

        final String departmentName = this.userRepository.findDepartmentNameByUserName(CHARLIE_NAME);

        assertEquals(CHARLIE_DEPARTMENT_NAME, departmentName);

    }

    @Test
    void when_username_is_passed_and_exists_should_return_the_project_name_which_belongs() {

        final String projectName = this.userRepository.findProjectNameByUserName(CHARLIE_NAME);


        assertEquals(CHARLIE_PROJECT_NAME, projectName);
    }
}