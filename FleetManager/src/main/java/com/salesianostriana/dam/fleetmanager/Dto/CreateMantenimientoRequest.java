package com.salesianostriana.dam.fleetmanager.Dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreateMantenimientoRequest(
        @NotNull (message = "{CreateMantenimientoRequest.idVehiculo.notNull}")
        Long idVehiculo,

        @NotNull
        Long idTaller,

        @NotBlank
        String tipo,

        @NotNull
        LocalDate fecha,

        @Min(0)
        int kmEnRevision
) {
}
