package com.techCamp.backend.api;

import com.techCamp.backend.dto.RequestEvaluationDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(EvaluationAPI.BASE_EVALUATION_URL)
public interface EvaluationAPI {
    String BASE_EVALUATION_URL = "/evaluation";

    @PostMapping("/doEvaluation")
    boolean evaluateRule(@RequestBody RequestEvaluationDTO evaluation);
}
