package com.techCamp.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestEvaluationDTO {
    private int ruleId;
    private int tableId;
    private String key;
    private String value;
}
