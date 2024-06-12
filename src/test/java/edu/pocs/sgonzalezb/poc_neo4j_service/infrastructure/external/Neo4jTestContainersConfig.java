package edu.pocs.sgonzalezb.poc_neo4j_service.infrastructure.external;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.GraphDatabase;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.Neo4jContainer;
import org.testcontainers.junit.jupiter.Container;

@TestConfiguration
public class Neo4jTestContainersConfig {

    @Container
    private static Neo4jContainer<?> neo4jContainer = new Neo4jContainer<>("neo4j:latest")
            .withAdminPassword("your_password");

    @BeforeAll
    static void setUp() {
        neo4jContainer.withReuse(true);
        neo4jContainer.start();

        initDb();
    }

    @DynamicPropertySource
    static void neo4jProperties(final DynamicPropertyRegistry registry) {
        registry.add("neo4j.datasources.uri", neo4jContainer::getBoltUrl);
        registry.add("neo4j.datasources.username", () -> "neo4j");
        registry.add("neo4j.datasources.password", neo4jContainer::getAdminPassword);
    }

    @AfterAll
    static void tearDown() {
        neo4jContainer.stop();
    }

    private static void initDb() {
        final var driver = GraphDatabase.driver(neo4jContainer.getBoltUrl(), AuthTokens.basic("neo4j", neo4jContainer.getAdminPassword()));

        driver.session().run("""
                // Create Companies
                CREATE (c1:Company {id: 1, name: 'TechCorp', industry: 'Technology', location: 'San Francisco'})
                CREATE (c2:Company {id: 2, name: 'HealthInc', industry: 'Healthcare', location: 'New York'})

                // Create Departments
                CREATE (d1:Department {id: 1, name: 'Development', location: 'San Francisco'})
                CREATE (d2:Department {id: 2, name: 'Marketing', location: 'New York'})
                CREATE (d3:Department {id: 3, name: 'Human Resources', location: 'San Francisco'})

                // Create Users
                CREATE (u1:User {id: 1, name: 'Alice', email: 'alice@techcorp.com', role: 'Engineer', hire_date: date('2022-01-15')})
                CREATE (u2:User {id: 2, name: 'Bob', email: 'bob@techcorp.com', role: 'Manager', hire_date: date('2020-05-20')})
                CREATE (u3:User {id: 3, name: 'Charlie', email: 'charlie@healthinc.com', role: 'Marketing Specialist', hire_date: date('2019-03-11')})
                CREATE (u4:User {id: 4, name: 'David', email: 'david@healthinc.com', role: 'Marketing Director', hire_date: date('2018-08-30')})

                // Create Projects
                CREATE (p1:Project {id: 1, name: 'Project Alpha', description: 'Development of a new mobile app', start_date: date('2023-01-01'), end_date: date('2023-12-31')})
                CREATE (p2:Project {id: 2, name: 'Project Beta', description: 'Marketing campaign for new product', start_date: date('2023-04-01'), end_date: date('2023-10-31')})

                // Create Relationships
                // Users and Companies
                CREATE (u1)-[:WORKS_FOR]->(c1)
                CREATE (u2)-[:WORKS_FOR]->(c1)
                CREATE (u3)-[:WORKS_FOR]->(c2)
                CREATE (u4)-[:WORKS_FOR]->(c2)

                // Users and Departments
                CREATE (u1)-[:BELONGS_TO]->(d1)
                CREATE (u2)-[:BELONGS_TO]->(d1)
                CREATE (u3)-[:BELONGS_TO]->(d2)
                CREATE (u4)-[:BELONGS_TO]->(d2)

                // Supervision
                CREATE (u2)-[:SUPERVISES]->(u1)
                CREATE (u4)-[:SUPERVISES]->(u3)

                // Projects and Companies
                CREATE (p1)-[:PROJECT_OF]->(c1)
                CREATE (p2)-[:PROJECT_OF]->(c2)

                // Project Assignments
                CREATE (u1)-[:ASSIGNED_TO]->(p1)
                CREATE (u3)-[:ASSIGNED_TO]->(p2)

                // Departments and Companies
                CREATE (d1)-[:PART_OF]->(c1)
                CREATE (d2)-[:PART_OF]->(c2)
                CREATE (d3)-[:PART_OF]->(c1)

                """);

        driver.close();
    }
}
