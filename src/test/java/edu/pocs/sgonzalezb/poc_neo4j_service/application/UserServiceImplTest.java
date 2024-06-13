package edu.pocs.sgonzalezb.poc_neo4j_service.application;

import edu.pocs.sgonzalezb.poc_neo4j_service.domain.user.model.User;
import edu.pocs.sgonzalezb.poc_neo4j_service.domain.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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

    }

    @Test
    void given_valid_username_then_should_return_the_name_of_the_company_is_working() {

    }

    @Test
    void given_valid_username_then_should_return_the_department_name_which_belongs() {

    }

    @Test
    void given_valid_username_then_should_return_the_project_name_which_belongs() {
    }

}