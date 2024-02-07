package com.bench.msusers.mapper;

import com.bench.msusers.dto.UserResponseDTO;
import com.bench.users.commons.model.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    public UserResponseDTO toDTO(User user);

    public User toModel(UserResponseDTO userResponseDTO);
}
