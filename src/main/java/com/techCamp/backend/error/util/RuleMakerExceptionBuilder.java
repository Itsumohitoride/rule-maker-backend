package com.techCamp.backend.error.util;

import com.techCamp.backend.Enum.ErrorCode;
import com.techCamp.backend.error.exception.DetailBuilder;
import com.techCamp.backend.error.exception.RuleMakerError;
import com.techCamp.backend.error.exception.RuleMakerErrorDetail;
import com.techCamp.backend.error.exception.RuleMakerException;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

public class RuleMakerExceptionBuilder {
    public RuleMakerException noPermissionException(String message){
        RuleMakerError error = createRuleMakerError(HttpStatus.UNAUTHORIZED, new DetailBuilder(ErrorCode.ERROR_401,
                ErrorCode.ERROR_401.getMessage()));
        return new RuleMakerException(message, error);
    }

    public RuleMakerException notFoundException(String message, String field){
        RuleMakerError error = createRuleMakerError(HttpStatus.NOT_FOUND, new DetailBuilder(ErrorCode.ERROR_404, field));
        return new RuleMakerException(message, error);
    }

    public RuleMakerException badRequestException(String message, String field){
        RuleMakerError error = createRuleMakerError(HttpStatus.BAD_REQUEST, new DetailBuilder(ErrorCode.ERROR_400, field));
        return new RuleMakerException(message, error);
    }

    public static RuleMakerException duplicatedValueException(String message, String field){
        RuleMakerError error = createRuleMakerError(HttpStatus.CONFLICT, new DetailBuilder(ErrorCode.ERR_DUPLICATED, field));
        return new RuleMakerException(message, error);
    }

    public static RuleMakerError createRuleMakerError(HttpStatus httpStatus, DetailBuilder... details) {
        return RuleMakerError.builder()
                .status(httpStatus)
                .details(
                        Arrays.stream(details)
                                .map(RuleMakerExceptionBuilder::mapToRuleMakerErrorDetail)
                                .toList()
                )
                .build();
    }

    private static RuleMakerErrorDetail mapToRuleMakerErrorDetail(DetailBuilder detailBuilder) {
        return RuleMakerErrorDetail.builder()
                .errorCode(detailBuilder.getErrorCode().getCode())
                .errorMessage(detailBuilder.getErrorCode().getMessage().formatted(detailBuilder.getFields()))
                .build();
    }
}
