package edu.pocs.sgonzalezb.poc_neo4j_service.application;

import edu.pocs.sgonzalezb.poc_neo4j_service.domain.user.model.User;
import edu.pocs.sgonzalezb.poc_neo4j_service.domain.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.assertj.core.api.BDDAssertions.then;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void given_valid_username_then_should_return_the_name_of_the_user() {

        //FIXME: apply ObjectMother pattern for test
        final User expected = new User("Alice", "alice@techcorp.com", LocalDate.parse("2022-01-15"), "Engineer");

        BDDMockito.given(this.userRepository.findUserByName("Alice"))
                .willReturn(expected);

        final User alice = this.userService.findUserByName("Alice");

        then(alice).isEqualTo(expected);
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