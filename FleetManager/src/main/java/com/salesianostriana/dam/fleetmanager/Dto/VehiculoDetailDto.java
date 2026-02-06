package com.salesianostriana.dam.fleetmanager.Dto;

import java.util.List;

public record VehiculoDetailDto(
        VehiculoSummaryDto vehiculoSummaryDto,
        List<AsignacionSummaryDto> asignaciones,
        MantenimientoSummaryDto ultimoMantenimiento
) {
}
