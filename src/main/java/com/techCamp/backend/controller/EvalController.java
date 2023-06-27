package com.techCamp.backend.controller;

import com.techCamp.backend.api.EvaluationAPI;
import com.techCamp.backend.dto.RequestEvaluationDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techCamp.backend.service.EvalService;


@RestController
@RequestMapping(EvaluationAPI.BASE_EVALUATION_URL)
@AllArgsConstructor
public class EvalController implements EvaluationAPI {
    private final EvalService evalService;

    @Override
    public boolean evaluateRule(RequestEvaluationDTO evaluation){
        return evalService.evaluate(evaluation.getRuleId(), evaluation.getTableId(), evaluation.getKey(), evaluation.getValue());
    }
}
