package com.salesianostriana.dam.fleetmanager.Dtos;

import java.time.LocalDate;

public record CreateMantenimientoRequest(
        Long idVehculo,
        Long idTaller,
        String tipo,
        LocalDate fecha,
        int kmEnRevision
) {
}
