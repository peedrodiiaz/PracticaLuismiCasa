package com.salesianostriana.dam.fleetmanager.Dtos;

import com.salesianostriana.dam.fleetmanager.Models.Asignacion;

import java.time.LocalDate;

public record AsignacionSummaryDto(
        Long id,
        LocalDate fechaInicio,
        LocalDate fechaFin,
        String nombreConductor,
        String matriculaVehiculo

) {
    public static AsignacionSummaryDto of (Asignacion a){
        return new AsignacionSummaryDto(
                a.getId(),
                a.getFechaInicio(),
                a.getFechaFin(),
                a.getConductor().getNombre(),
                a.getVehiculo().getMatricula()
        );

    }
}
