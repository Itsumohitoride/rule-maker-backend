package com.techCamp.backend.error.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Builder
@Getter
public class RuleMakerError {
    private HttpStatus status;
    private List<RuleMakerErrorDetail> details;
}
