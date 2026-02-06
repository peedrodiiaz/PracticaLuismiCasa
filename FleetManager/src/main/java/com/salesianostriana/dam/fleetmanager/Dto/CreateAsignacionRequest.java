package com.salesianostriana.dam.fleetmanager.Dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreateAsignacionRequest(
                @NotNull
                Long id,
                @NotNull
                Long idConductor,
                @NotEmpty
                LocalDate fecha
) {
}
