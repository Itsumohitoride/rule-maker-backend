package com.techCamp.backend.validation.ValidateEmailorPhone;
import com.techCamp.backend.dto.CreateUsersDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailOrPhoneValidator implements ConstraintValidator<EmailOrPhoneConstraint, CreateUsersDto> {

    @Override
    public void initialize(EmailOrPhoneConstraint contactNumber) {
    }

    @Override
    public boolean isValid(CreateUsersDto user, ConstraintValidatorContext constraintValidatorContext) {
        return !user.email().isBlank() || !user.phoneNumber().isBlank();
    }
}
