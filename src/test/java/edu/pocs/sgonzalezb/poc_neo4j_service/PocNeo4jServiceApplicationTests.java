package edu.pocs.sgonzalezb.poc_neo4j_service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PocNeo4jServiceApplicationTests {

    @Test
    void when_username_is_passed_and_exists_should_return_all_the_directly_users_relationships() {

    }

    @Test
    void when_username_is_passed_and_not_exists_should_return_empty() {

    }

    @Test
    void when_username_is_passed_and_have_only_a_directly_boss_should_return_directly_boss_name() {

    }

    @Test
    void when_username_is_passed_and_have_a_boss_wich_also_have_another_boss_should_return_superior_boss_name() {

    }
}
