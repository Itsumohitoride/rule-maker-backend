package com.techCamp.backend.mapper;

import com.techCamp.backend.dto.CreateUsersDTO;
import com.techCamp.backend.dto.ResponseUserDTO;
import com.techCamp.backend.model.Users;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    Users fromCreateUserDTO(CreateUsersDTO createUsersDto);

    CreateUsersDTO fromUser(Users users);
    ResponseUserDTO fromUserToResponseUserDTO(Users users);
}
