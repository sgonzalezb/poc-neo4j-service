package edu.pocs.sgonzalezb.poc_neo4j_service.domain.user.service;

import edu.pocs.sgonzalezb.poc_neo4j_service.domain.user.model.User;

import java.util.List;

public interface UserService {

    User findUserByName();

    List<String> findDependentsNamesByUserName();

    String findCompanyNameByUserName();

    String findDepartmentNameByUserName();

    String findProjectNameByUserName();
}
