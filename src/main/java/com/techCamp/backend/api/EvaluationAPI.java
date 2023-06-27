package com.techCamp.backend.api;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(EvaluationAPI.BASE_EVALUATION_URL)
public interface EvaluationAPI {
    String BASE_EVALUATION_URL = "/evaluation";
}
