package com.salesianostriana.dam.clinicflow.dto;

import com.salesianostriana.dam.clinicflow.model.Cita;
import com.salesianostriana.dam.clinicflow.model.Estado;

import java.time.LocalDateTime;

public record CitaListDto(
        LocalDateTime fechahora,
        Estado estado,
        String pacienteNombre,
        String profesionalNombre,
        String diagnosticoConsulta
) {
    public static CitaListDto of (Cita c){
        return new CitaListDto(
                c.getFechaHora(),
                c.getEstado(),
                c.getPaciente().getNombre(),
                c.getProfesional().getNombre(),
                c.getConsulta().getDiagnostico()
        );
    }
}
