package com.techCamp.backend.dto;

import lombok.Builder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
public record LoginDTO(

        @NotNull
        @NotBlank
        String username,
        @NotNull
        @NotBlank
        String password) {
}
