package com.salesianostriana.dam.clinicflow.controller;

import com.salesianostriana.dam.clinicflow.dto.CitaDetailDto;
import com.salesianostriana.dam.clinicflow.dto.CreateCitaRequest;
import com.salesianostriana.dam.clinicflow.dto.CreateConsultaRequest;
import com.salesianostriana.dam.clinicflow.model.Cita;
import com.salesianostriana.dam.clinicflow.service.CitaService;
import com.salesianostriana.dam.clinicflow.service.ConsultaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/citas")
public class CitaController {

    private final CitaService citaService;
    private final ConsultaService consultaService;

    @PostMapping()
    public ResponseEntity<CitaDetailDto>create (CreateCitaRequest
                                                cmd)
    {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CitaDetailDto.of(citaService.createCita(cmd)));
    }

    @PutMapping ("/{id}/cancelar")
    public ResponseEntity <CitaDetailDto> cancelar(@PathVariable Long id){
        return ResponseEntity.ok(CitaDetailDto.of(citaService.cancelarCita(id)));

    }
    @PutMapping ("/{id}/consulta")
    public ResponseEntity<CitaDetailDto> registrarConsulta(@PathVariable Long id, CreateConsultaRequest cmd){
        return ResponseEntity.ok(
                CitaDetailDto.of(citaService.createConsulta(cmd,id))
        );
    }

    @GetMapping()
    public Page<CitaDetailDto>getAll(
            @PageableDefault(page = 0,value = 20)Pageable pageable
    ){
        return citaService.getAll(pageable).map(
                CitaDetailDto::of
        );
    }









}
