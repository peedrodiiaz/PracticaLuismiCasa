package com.salesianostriana.dam.fleetmanager.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.salesianostriana.dam.fleetmanager.validation.UniqueType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreateMantenimientoRequest(
        @NotNull (message = "{CreateMantenimientoRequest.idVehiculo.notNull}")
        @UniqueType
        Long idVehiculo,

        @NotNull
        Long idTaller,

        @NotBlank
        String tipo,

        @NotNull
        @JsonFormat(pattern = "dd-MM-yy")
        LocalDate fecha,

        @Min(0)
        int kmEnRevision
) {
}
