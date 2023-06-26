package com.techCamp.backend.error;

import com.techCamp.backend.Enum.ErrorCode;
import com.techCamp.backend.error.exception.DetailBuilder;
import com.techCamp.backend.error.exception.RuleMakerError;
import com.techCamp.backend.error.exception.RuleMakerErrorDetail;
import com.techCamp.backend.error.exception.RuleMakerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.techCamp.backend.error.util.RuleMakerExceptionBuilder.createRuleMakerError;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<RuleMakerError> handleLoginException(
            BadCredentialsException badCredentialsException){
        var error = createRuleMakerError(HttpStatus.UNAUTHORIZED, new DetailBuilder(ErrorCode.ERROR_401));
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }

    @ExceptionHandler(RuleMakerException.class)
    public ResponseEntity<RuleMakerError> handleCellphoneException(RuleMakerException exception){
        return ResponseEntity.status(exception.getError().getStatus()).body(exception.getError());
    }

   @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<RuleMakerError> handleRuntimeException(){
        var error = createRuleMakerError(HttpStatus.INTERNAL_SERVER_ERROR, new DetailBuilder(ErrorCode.ERROR_500));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RuleMakerError> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception){
        var errorBuilder = RuleMakerError.builder().status(HttpStatus.BAD_REQUEST);
        var details = exception.getBindingResult().getAllErrors().stream().map(this::mapBindingResultError).toList();
        var error = errorBuilder.details(details).build();
        return ResponseEntity.status(error.getStatus()).body(error);
    }

    private RuleMakerErrorDetail mapBindingResultError(ObjectError objectError) {
        var message = ErrorCode.ERROR_400.getMessage().formatted(((FieldError) objectError).getField(), objectError.getDefaultMessage());
        return RuleMakerErrorDetail.builder()
                .errorCode(ErrorCode.ERROR_400.getCode())
                .errorMessage(message)
                .build();
    }
}
