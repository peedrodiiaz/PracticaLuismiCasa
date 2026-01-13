package com.salesianostriana.dam.fleetmanager.Dtos;

import java.time.LocalDate;

public record AsignacionSummaryDto(
        Long id,
        LocalDate fechaInicio,
        LocalDate fechaFin,
        String nombreConductor

) {
}
