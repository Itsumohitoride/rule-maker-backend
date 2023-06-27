package com.techCamp.backend.mapper;

import com.techCamp.backend.dto.CreateUsersDTO;
import com.techCamp.backend.dto.ResponseUserDTO;
import com.techCamp.backend.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User fromCreateUserDTO(CreateUsersDTO createUsersDto);

    CreateUsersDTO fromUser(User users);
    ResponseUserDTO fromUserToResponseUserDTO(User users);
}
