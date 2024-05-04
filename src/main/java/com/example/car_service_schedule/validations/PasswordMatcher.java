package com.example.car_service_schedule.validations;

import com.example.car_service_schedule.models.dto.UserRegisterInfoDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

public class PasswordMatcher implements ConstraintValidator<PasswordMatch, UserRegisterInfoDTO> {

    private String password;
    private String confirmPassword;
    private String message;

    @Override
    public void initialize(PasswordMatch constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.password = constraintAnnotation.password();
        this.confirmPassword = constraintAnnotation.confirmPassword();
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(UserRegisterInfoDTO userRegisterInfoDTO, ConstraintValidatorContext constraintValidatorContext) {
        BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(userRegisterInfoDTO);
        Object propertyValue1 = beanWrapper.getPropertyValue(this.password);
        Object propertyValue2 = beanWrapper.getPropertyValue(this.confirmPassword);

        if (propertyValue1 != null && propertyValue1.equals(propertyValue2)) {
            return true;
        }

        constraintValidatorContext.buildConstraintViolationWithTemplate(message)
                .addPropertyNode(confirmPassword)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }
}
