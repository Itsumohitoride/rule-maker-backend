package com.techCamp.backend.dto;

import com.techCamp.backend.model.TableId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestEvaluationDTO {
    private int ruleId;
    private TableId tableId;
    private String key;
    private String value;
}
