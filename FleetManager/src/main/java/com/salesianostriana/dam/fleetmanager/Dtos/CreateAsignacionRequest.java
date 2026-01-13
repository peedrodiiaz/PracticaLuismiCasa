package com.salesianostriana.dam.fleetmanager.Dtos;

import java.time.LocalDate;

public record CreateAsignacionRequest(
        Long id,
        Long idConductor,
        LocalDate fecha
) {
}
