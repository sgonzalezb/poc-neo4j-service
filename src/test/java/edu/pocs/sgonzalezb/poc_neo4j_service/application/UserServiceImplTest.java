package edu.pocs.sgonzalezb.poc_neo4j_service.application;

import edu.pocs.sgonzalezb.poc_neo4j_service.domain.user.model.User;
import edu.pocs.sgonzalezb.poc_neo4j_service.domain.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static edu.pocs.sgonzalezb.poc_neo4j_service.domain.user.UserObjectMother.createAliceUser;
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
        given(this.userRepository.findUserByName("Alice"))
                .willReturn(ALICE_USER);

        ///When
        final User user = this.userService.findUserByName("Alice");

        //Then
        then(user).isEqualTo(ALICE_USER);
    }


    @Test
    void given_valid_username_then_should_return_the_names_of_users_that_depend_on_it() {

        //Expected
        final List<String> expectedDependents = List.of("Charlie");

        //Given
        given(this.userRepository.findDependentsNamesByUserName("David"))
                .willReturn(expectedDependents);

        ///When
        final List<String> dependentsUsers = this.userService.findDependentsNamesByUserName("David");

        //Then
        then(dependentsUsers).isEqualTo(expectedDependents);
    }

    @Test
    void given_valid_username_then_should_return_the_name_of_the_company_is_working() {

        //Expected
        final String aliceCompanyName = "TechCorp";

        //Given
        given(this.userRepository.findCompanyNameByUserName("Alice"))
                .willReturn(aliceCompanyName);

        ///When
        final String companyName = this.userService.findCompanyNameByUserName("Alice");

        //Then
        then(companyName).isEqualTo(aliceCompanyName);
    }

    @Test
    void given_valid_username_then_should_return_the_department_name_which_belongs() {

        //Expected
        final String charlieDepartmentName = "Marketing";

        //Given
        given(this.userRepository.findDepartmentNameByUserName("Charlie"))
                .willReturn(charlieDepartmentName);

        ///When
        final String dependentsUsers = this.userService.findDepartmentNameByUserName("Charlie");

        //Then
        then(dependentsUsers).isEqualTo(charlieDepartmentName);
    }

    @Test
    void given_valid_username_then_should_return_the_project_name_which_belongs() {

        //Expected
        final String charlieProjectName = "ProjectBeta";

        //Given
        given(this.userRepository.findProjectNameByUserName("Charlie"))
                .willReturn(charlieProjectName);

        ///When
        final String dependentsUsers = this.userService.findProjectNameByUserName("Charlie");

        //Then
        then(dependentsUsers).isEqualTo(charlieProjectName);
    }

}