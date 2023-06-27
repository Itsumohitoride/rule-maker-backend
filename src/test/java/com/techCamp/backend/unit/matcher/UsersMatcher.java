package com.techCamp.backend.unit.matcher;


import com.techCamp.backend.model.Users;
import org.mockito.ArgumentMatcher;

import java.util.Objects;

public class UsersMatcher implements ArgumentMatcher<Users> {

    private final Users users;


    public UsersMatcher(Users users) {
        this.users = users;
    }


    @Override
    public boolean matches(Users usersOne) {

        return usersOne.getUserId() != null &&
                Objects.equals(usersOne.getFirstName(), users.getFirstName()) &&
                Objects.equals(usersOne.getLastName(), users.getLastName()) &&
                Objects.equals(usersOne.getEmail(), users.getEmail()) &&
                Objects.equals(usersOne.getPassword(), users.getPassword()) &&
                Objects.equals(usersOne.getPhoneNumber(), users.getPhoneNumber()) &&
                Objects.equals(usersOne.getRole(), users.getRole());

    }


}