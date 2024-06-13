package edu.pocs.sgonzalezb.poc_neo4j_service.application;

import edu.pocs.sgonzalezb.poc_neo4j_service.domain.user.model.User;
import edu.pocs.sgonzalezb.poc_neo4j_service.domain.user.repository.UserRepository;
import edu.pocs.sgonzalezb.poc_neo4j_service.domain.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserByName(final String name) {
        return this.userRepository.findUserByName(name);
    }

    @Override
    public List<String> findDependentsNamesByUserName(final String name) {
        return List.of();
    }

    @Override
    public String findCompanyNameByUserName(final String name) {
        return "";
    }

    @Override
    public String findDepartmentNameByUserName(final String name) {
        return "";
    }

    @Override
    public String findProjectNameByUserName(final String name) {
        return "";
    }
}
