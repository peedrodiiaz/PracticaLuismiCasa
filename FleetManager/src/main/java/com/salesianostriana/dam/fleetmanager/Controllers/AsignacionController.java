package com.salesianostriana.dam.fleetmanager.Controllers;

import ch.qos.logback.core.util.StringUtil;
import com.salesianostriana.dam.fleetmanager.Dtos.AsignacionSummaryDto;
import com.salesianostriana.dam.fleetmanager.Models.Asignacion;
import com.salesianostriana.dam.fleetmanager.Services.AsignacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping ("asignaciones/")
@RequiredArgsConstructor
public class AsignacionController {
    private final AsignacionService asignacionService;

    @GetMapping
    public List<AsignacionSummaryDto> getAll(){
        return asignacionService.getAll()
                .stream().map(AsignacionSummaryDto::of).toList();

    }
    @PostMapping("/{conductorId}/{vehiculoId}")
    public AsignacionSummaryDto asignar(@PathVariable  Long conductorID, @PathVariable Long vehiculoId){

        Asignacion asignacion = asignacionService.asignarVehiculo(conductorID,vehiculoId);
        return AsignacionSummaryDto.of(asignacion);

    }

}
