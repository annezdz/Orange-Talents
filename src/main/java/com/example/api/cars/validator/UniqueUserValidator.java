package com.example.api.cars.validator;

import com.example.api.cars.repository.UserRepository;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UniqueUserValidator implements ConstraintValidator<UniqueUser, String> {

    private final UserRepository userRepository;

    public UniqueUserValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void initialize(UniqueUser constraintAnnotation){ }

    @Override
    public boolean isValid(String userField, ConstraintValidatorContext context) {
        return userField != null && !(userRepository.existsByCpf(userField)
                || userRepository.existsByEmail(userField));
    }
}
