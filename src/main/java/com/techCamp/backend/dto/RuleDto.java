package com.techCamp.backend.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RuleDto {
    private String name;
    private String rule;
}
