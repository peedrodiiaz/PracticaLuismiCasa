package com.salesianostriana.dam.fleetmanager.Dtos;

import java.time.LocalDate;

public record MantenimientoSummaryDto(
        Long id,
        String tipo,
        LocalDate fecha,
        int kmRevision,
        String nombreTaller
) {
}
