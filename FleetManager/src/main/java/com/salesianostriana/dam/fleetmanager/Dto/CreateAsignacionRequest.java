package com.salesianostriana.dam.fleetmanager.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreateAsignacionRequest(
                @NotNull
                Long id,
                @NotNull
                Long idConductor,
                @NotNull
                @JsonFormat(pattern = "dd-MM-yy")
                LocalDate fecha
) {
}
