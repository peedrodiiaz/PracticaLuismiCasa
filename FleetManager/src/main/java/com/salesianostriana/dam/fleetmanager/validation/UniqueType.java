package com.salesianostriana.dam.fleetmanager.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(
        {ElementType.METHOD, ElementType.FIELD}
)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = UniqueTypeValidator.class)
public @interface UniqueType {


    String message()default "El id no se puede repetir";

    Class<?> [] groups()default {};

    Class <? extends Payload>[] payload()default {};
}
