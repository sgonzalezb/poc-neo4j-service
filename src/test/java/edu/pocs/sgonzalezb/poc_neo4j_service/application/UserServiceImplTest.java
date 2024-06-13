package edu.pocs.sgonzalezb.poc_neo4j_service.application;

import edu.pocs.sgonzalezb.poc_neo4j_service.domain.user.model.User;
import edu.pocs.sgonzalezb.poc_neo4j_service.domain.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static edu.pocs.sgonzalezb.poc_neo4j_service.domain.user.UserObjectMother.*;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    private final static User ALICE_USER = createAliceUser();

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void given_valid_username_then_should_return_the_name_of_the_user() {

        //Given
        given(this.userRepository.findUserByName(ALICE_NAME))
                .willReturn(ALICE_USER);

        ///When
        final User user = this.userService.findUserByName(ALICE_NAME);

        //Then
        then(user).isEqualTo(ALICE_USER);
    }


    @Test
    void given_valid_username_then_should_return_the_names_of_users_that_depend_on_it() {

        //Given
        given(this.userRepository.findDependentsNamesByUserName(DAVID_NAME))
                .willReturn(List.of(CHARLIE_PROJECT_NAME));

        ///When
        final List<String> dependentsUsers = this.userService.findDependentsNamesByUserName(DAVID_NAME);

        //Then
        then(dependentsUsers).isEqualTo(List.of(CHARLIE_PROJECT_NAME));
    }

    @Test
    void given_valid_username_then_should_return_the_name_of_the_company_is_working() {
        //Given
        given(this.userRepository.findCompanyNameByUserName(ALICE_NAME))
                .willReturn(ALICE_COMPANY);

        ///When
        final String companyName = this.userService.findCompanyNameByUserName(ALICE_NAME);

        //Then
        then(companyName).isEqualTo(ALICE_COMPANY);
    }

    @Test
    void given_valid_username_then_should_return_the_department_name_which_belongs() {

        //Given
        given(this.userRepository.findDepartmentNameByUserName(CHARLIE_NAME))
                .willReturn(CHARLIE_PROJECT_NAME);

        ///When
        final String dependentsUsers = this.userService.findDepartmentNameByUserName(CHARLIE_NAME);

        //Then
        then(dependentsUsers).isEqualTo(CHARLIE_PROJECT_NAME);
    }

    @Test
    void given_valid_username_then_should_return_the_project_name_which_belongs() {

        //Given
        given(this.userRepository.findProjectNameByUserName(CHARLIE_NAME))
                .willReturn(CHARLIE_PROJECT_NAME);

        ///When
        final String dependentsUsers = this.userService.findProjectNameByUserName(CHARLIE_NAME);

        //Then
        then(dependentsUsers).isEqualTo(CHARLIE_PROJECT_NAME);
    }

}