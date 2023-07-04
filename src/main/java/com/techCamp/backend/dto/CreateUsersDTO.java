package com.techCamp.backend.dto;


import com.techCamp.backend.validation.ValidateEmailorPhone.EmailOrPhoneConstraint;
import lombok.Builder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Builder
@EmailOrPhoneConstraint
public record CreateUsersDTO(
    String firstName,
    String lastName,
    @Email
    String email,
    String phoneNumber,
    @NotNull
    @NotBlank
    String password) {
}
