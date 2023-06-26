package com.techCamp.backend.error.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class RuleMakerErrorDetail {
    private String errorCode;
    private String errorMessage;
}
