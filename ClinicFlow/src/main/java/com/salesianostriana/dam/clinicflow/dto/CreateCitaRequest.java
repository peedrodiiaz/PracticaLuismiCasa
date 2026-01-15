package com.salesianostriana.dam.clinicflow.dto;

import com.salesianostriana.dam.clinicflow.model.Estado;
import com.salesianostriana.dam.clinicflow.model.Paciente;

import java.time.LocalDateTime;

public record CreateCitaRequest(

        LocalDateTime fechaHora,
        Long pacienteId,
        Long profesionalId

) {
}
