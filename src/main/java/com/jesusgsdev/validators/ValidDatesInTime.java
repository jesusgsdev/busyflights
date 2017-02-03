package com.jesusgsdev.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by jesgarsal on 01/02/17.
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ValidDatesInTimeValidator.class})
public @interface ValidDatesInTime {

    String message() default "{com.jesusgsdev.validDatesInTimeValidator.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
