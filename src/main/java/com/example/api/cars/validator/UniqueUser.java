package com.example.api.cars.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = UniqueUserValidator.class)
@Target({FIELD, METHOD})
@Retention(RUNTIME)
public @interface UniqueUser {

    String message() default "The user already exists";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
