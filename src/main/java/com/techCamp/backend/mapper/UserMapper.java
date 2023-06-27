package com.techCamp.backend.mapper;

import com.techCamp.backend.dto.CreateUsersDto;
import com.techCamp.backend.dto.ResponseUserDTO;
import com.techCamp.backend.model.Users;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    Users fromCreateUserDTO(CreateUsersDto createUsersDto);

    CreateUsersDto fromUser(Users users);
    ResponseUserDTO fromUserToResponseUserDTO(Users users);
}
