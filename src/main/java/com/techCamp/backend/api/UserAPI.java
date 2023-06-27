package com.techCamp.backend.api;

import com.techCamp.backend.dto.CreateUsersDTO;
import com.techCamp.backend.dto.ResponseUserDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(UserAPI.BASE_USER_URL)
public interface UserAPI {
    String BASE_USER_URL = "/user";
    @PostMapping("/create")
    ResponseUserDTO save(@RequestBody CreateUsersDTO usersDTO);
}
