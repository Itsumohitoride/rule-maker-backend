package com.techCamp.backend.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    ERROR_404("ERR_404", "Not found %s"),
    ERROR_500("ERR_500", "Oops, we ran into an error"),
    ERROR_400("ERR_400", "Problem with %s"),
    ERROR_401("ERR_401", "Unauthorized"),
    ERR_REQUIRED_FIELD("ERR_REQUIRED_FIELD", "Fields %s is required"),
    ERR_ROL_NOT_FOUND("ERR_ROL_NOT_FOUND", "%s, rol not exists."),
    ERR_DUPLICATED("ERR_DUPLICATED", "%s, already exists.");

    private final String code;
    private final String message;
}