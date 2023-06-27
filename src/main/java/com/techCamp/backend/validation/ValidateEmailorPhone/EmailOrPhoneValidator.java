package com.techCamp.backend.validation.ValidateEmailorPhone;
import com.techCamp.backend.dto.CreateUsersDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailOrPhoneValidator implements ConstraintValidator<EmailOrPhoneConstraint, CreateUsersDTO> {

    @Override
    public void initialize(EmailOrPhoneConstraint contactNumber) {
    }

    @Override
    public boolean isValid(CreateUsersDTO user, ConstraintValidatorContext constraintValidatorContext) {
        return !user.email().isBlank() || !user.phoneNumber().isBlank();
    }
}
