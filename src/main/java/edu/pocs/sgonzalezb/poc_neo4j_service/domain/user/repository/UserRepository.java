package edu.pocs.sgonzalezb.poc_neo4j_service.domain.user.repository;

import edu.pocs.sgonzalezb.poc_neo4j_service.domain.user.model.User;

import java.util.List;

public interface UserRepository {

    User findUserByName(String name);

    List<String> findDependentsNamesByUserName(String name);

    String findCompanyNameByUserName(String name);

    String findDepartmentNameByUserName(String name);

    String findProjectNameByUserName(String name);
}
