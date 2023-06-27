package com.techCamp.backend.service;
import com.techCamp.backend.dto.CreateUsersDTO;
import com.techCamp.backend.dto.ResponseUserDTO;
import com.techCamp.backend.error.util.RuleMakerExceptionBuilder;
import com.techCamp.backend.mapper.UserMapper;
import com.techCamp.backend.model.Users;
import com.techCamp.backend.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UsersService {
    private final PasswordEncoder encoder;
    private final UsersRepository userRepository;
    private final UserMapper userMapper;
    public ResponseUserDTO save(CreateUsersDTO createUsersDto) {
        validateIfEmailIsDuplicated(createUsersDto.email());
        validateIfPhoneIsDuplicated(createUsersDto.phoneNumber());
        validateRole(createUsersDto.role());
        Users newUser = userMapper.fromCreateUserDTO(createUsersDto);
        newUser.setUserId(UUID.randomUUID());
        newUser.setPassword(encoder.encode(createUsersDto.password()));
        ResponseUserDTO userResponse = userMapper.fromUserToResponseUserDTO(userRepository.save(newUser));
        userResponse.setCustomerId(newUser.getUserId());
        return userResponse;
    }

    private void validateRole(String role) {
        boolean isValid = role.equalsIgnoreCase("ADMIN") || role.equalsIgnoreCase("USER");
        if(!isValid){
            throw RuleMakerExceptionBuilder.noFoundRoleException("Role not exist .", role);
        }
    }

    private void validateIfEmailIsDuplicated(String userEmail){
        if(userRepository.findByEmail(userEmail)){
            throw RuleMakerExceptionBuilder.duplicatedValueException(
                    "A user with the entered email already exists.", userEmail);
        }
    }

    private void validateIfPhoneIsDuplicated(String userPhone){
        if(userRepository.findByPhoneNumber(userPhone)){
            throw RuleMakerExceptionBuilder.duplicatedValueException(
                    "A user with the entered phone already exists.", userPhone);
        }
    }
}
