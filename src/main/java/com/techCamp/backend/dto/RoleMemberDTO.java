package com.techCamp.backend.dto;

import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleMemberDTO {
    String groupId;
    @Email
    String email;
    String role;
}
