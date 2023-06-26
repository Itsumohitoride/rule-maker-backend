package com.techCamp.backend.error.exception;

import lombok.Getter;

@Getter
public class RuleMakerException extends RuntimeException{
    private final RuleMakerError error;

    public RuleMakerException(String message, RuleMakerError error){
        super(message);
        this.error = error;
    }
}
