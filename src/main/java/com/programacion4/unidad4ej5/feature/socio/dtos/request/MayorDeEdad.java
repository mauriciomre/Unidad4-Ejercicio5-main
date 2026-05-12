package com.programacion4.unidad4ej5.feature.socio.dtos.request;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;

import java.lang.annotation.*;
import java.time.LocalDate;
import java.time.Period;

@Documented
@Constraint(validatedBy = MayorDeEdad.Validator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MayorDeEdad {

    String message() default "El socio debe tener al menos 18 años";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    class Validator implements ConstraintValidator<MayorDeEdad, LocalDate> {
        @Override
        public boolean isValid(LocalDate fechaNacimiento, ConstraintValidatorContext context) {
            if (fechaNacimiento == null) return true;
            return Period.between(fechaNacimiento, LocalDate.now()).getYears() >= 18;
        }
    }
}