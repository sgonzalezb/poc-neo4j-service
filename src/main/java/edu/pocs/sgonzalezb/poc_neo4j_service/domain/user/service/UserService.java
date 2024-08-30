package edu.pocs.sgonzalezb.poc_neo4j_service.domain.user.service;

import edu.pocs.sgonzalezb.poc_neo4j_service.domain.user.model.User;

import java.util.List;

public interface UserService {

    User findUserByName(String name);

    List<String> findDependentsNamesByUserName(String name);

    String findCompanyNameByUserName(String name);

    String findDepartmentNameByUserName(String name);

    String findProjectNameByUserName(String name);
}
