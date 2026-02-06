package com.salesianostriana.dam.fleetmanager.Dto;

import com.salesianostriana.dam.fleetmanager.Models.Mantenimiento;

import java.time.LocalDate;

public record MantenimientoSummaryDto(
        Long id,
        String tipo,
        LocalDate fecha,
        int kmRevision,
        String nombreTaller,
        Long vehiculoId,
        Long tallerId
) {

    public static     MantenimientoSummaryDto of (Mantenimiento m){

        return new MantenimientoSummaryDto(
                m.getId(),
                m.getTipo(),
                m.getFecha(),
                m.getKmEnRevision(),
                m.getTaller().getNombre(),
                m.getVehiculo().getId(),
                m.getTaller().getId()
        );
    }
}
