package com.example.car_service_schedule.validations;

import com.example.car_service_schedule.models.dto.LoginUserInfoDTO;
import com.example.car_service_schedule.models.entity.Users;
import com.example.car_service_schedule.repositories.UsersRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class LoginUserDataMatcher implements ConstraintValidator<LoginUserDataMatch, LoginUserInfoDTO> {

    private final UsersRepository usersRepository;

    @Autowired
    public LoginUserDataMatcher(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public void initialize(LoginUserDataMatch constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(LoginUserInfoDTO loginUserInfoDTO, ConstraintValidatorContext constraintValidatorContext) {
        Optional<Users> loginCandidate = this.usersRepository
                .findByUsernameAndPassword(loginUserInfoDTO.getUsername(), loginUserInfoDTO.getPassword());

        return loginCandidate.isPresent();
    }
}
