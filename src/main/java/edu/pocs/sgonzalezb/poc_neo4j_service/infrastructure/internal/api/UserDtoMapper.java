package edu.pocs.sgonzalezb.poc_neo4j_service.infrastructure.internal.api;

import edu.pocs.sgonzalezb.poc_neo4j_service.domain.user.model.User;
import edu.pocs.sgonzalezb.poc_neo4j_service.infrastructure.internal.api.model.UserDto;

//todo: change for MapStruct
public interface UserDtoMapper {

    static UserDto fromModel(final User user) {

        return new UserDto(user.name(), user.email(), user.hireDate(), user.role());
    }
}
