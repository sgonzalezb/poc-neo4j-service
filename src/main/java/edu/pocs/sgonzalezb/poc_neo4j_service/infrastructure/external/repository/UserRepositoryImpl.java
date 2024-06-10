package edu.pocs.sgonzalezb.poc_neo4j_service.infrastructure.external.repository;

import edu.pocs.sgonzalezb.poc_neo4j_service.domain.user.model.User;
import edu.pocs.sgonzalezb.poc_neo4j_service.domain.user.repository.UserRepository;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private Driver driver;

    @Override
    public User findUserByName(final String name) {

        try (final Session session = this.driver.session()) {

            return UserMapper.fromMap(session.run("MATCH (user: User {name: 'Alice'}) RETURN user")
                    .single()
                    .get("user")
                    .asMap());
        }
    }


    @Override
    public List<String> findDependentsNamesByUserName(final String name) {

        try (final Session session = this.driver.session()) {

            return session.run("MATCH (user:User {name: 'David'})-[r:SUPERVISES]->(u:User) RETURN u.name as name")
                    .stream()
                    .map(record -> record.get("name").asString())
                    .toList();
        }
    }

    @Override
    public String findCompanyNameByUserName(final String name) {

        try (final Session session = this.driver.session()) {

            return session.run("MATCH (user:User {name: 'Alice'})-[r:WORKS_FOR]->(c:Company) RETURN c.name as name")
                    .single()
                    .get("name")
                    .asString();
        }

    }

    @Override
    public String findDepartmentNameByUserName(final String name) {

        try (final Session session = this.driver.session()) {

            return session.run("MATCH (user:User {name: 'Charlie'})-[r:BELONGS_TO]->(d:Department) RETURN d.name as name")
                    .single()
                    .get("name")
                    .asString();
        }
    }

    @Override
    public String findProjectNameByUserName(final String name) {

        try (final Session session = this.driver.session()) {
            return session.run("MATCH (user:User {name: 'Charlie'})-[r:ASSIGNED_TO]->(p:Project) RETURN p.name as name")
                    .single()
                    .get("name")
                    .asString();

        }
    }
}

