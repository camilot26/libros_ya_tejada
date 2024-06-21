package com.riwi.librosya.infraestructure.helpers.Mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;


import com.riwi.librosya.api.dto.request.UserRequest;
import com.riwi.librosya.api.dto.response.UserResponse;
import com.riwi.librosya.domain.entities.UserEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mappings({
        @Mapping(target = "id",ignore = true),
        @Mapping(target ="loans",ignore = true)
    }
    )
    UserEntity requesttoEntity (UserRequest userRequest);
    
    UserResponse entityToResponse(UserEntity entity);

    @Mapping(target = "password",ignore = true)
    UserEntity  responsetoEntity(UserResponse userResponse);

    List<UserResponse>  entityToResponse(List<UserEntity> entity);
}
