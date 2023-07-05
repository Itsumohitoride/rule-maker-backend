package com.techCamp.backend.dto;


import java.util.Map;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestEvaluationDTO {
    private RuleDto rule;
    private Map<String, Object> data;
}
