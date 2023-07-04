package com.techCamp.backend.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ResponseUserDTO {
    private String  userIds;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String role;
}
