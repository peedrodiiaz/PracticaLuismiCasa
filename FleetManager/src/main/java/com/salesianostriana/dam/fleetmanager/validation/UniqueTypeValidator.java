package com.salesianostriana.dam.fleetmanager.validation;

import com.salesianostriana.dam.fleetmanager.Repositories.MantenimientoRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UniqueTypeValidator implements ConstraintValidator<UniqueType,Long> {

    private final MantenimientoRepository mantenimientoRepository;


    @Override
    public void initialize(UniqueType constraintAnnotation) {
        String message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext constraintValidatorContext) {
        return id != null? !mantenimientoRepository.existsById(id) : false;
    }
}
