package com.techCamp.backend.controller;

import com.techCamp.backend.api.UserAPI;
import com.techCamp.backend.dto.CreateUsersDTO;
import com.techCamp.backend.dto.ResponseUserDTO;
import com.techCamp.backend.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UserAPI.BASE_USER_URL)
@AllArgsConstructor
public class UserController implements UserAPI{
    private final UsersService userService;

    @Override
    public ResponseUserDTO save(CreateUsersDTO userDTO){
        return userService.save(userDTO);
    }
}
