package com.salesianostriana.dam.fleetmanager.Controllers;

import com.salesianostriana.dam.fleetmanager.Dto.CreateMantenimientoRequest;
import com.salesianostriana.dam.fleetmanager.Dto.MantenimientoSummaryDto;
import com.salesianostriana.dam.fleetmanager.Services.MantenimientoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mantenimiento")
public class MantenimientoController {

    private final MantenimientoService mantenimientoService;


    @PostMapping
    public ResponseEntity<MantenimientoSummaryDto>create(@Valid @RequestBody CreateMantenimientoRequest cmd) {
        return ResponseEntity.ok(MantenimientoSummaryDto.of(mantenimientoService.registrarMantenimiento(cmd)));
    }
}
