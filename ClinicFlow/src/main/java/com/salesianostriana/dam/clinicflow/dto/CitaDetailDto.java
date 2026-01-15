package com.salesianostriana.dam.clinicflow.dto;

import com.salesianostriana.dam.clinicflow.model.*;

import java.time.LocalDateTime;

public record CitaDetailDto(
        Long id,
        LocalDateTime fechaHora,
        Estado estado,
        CitaDetailDto.PacienteSimpleDto pacienteDto,
        CitaDetailDto.ProfesionalSimpleDto profesionalDto,
        CitaDetailDto.ConsultaSimpleDto consultaSimpleDto
) {
    public record PacienteSimpleDto(Long id,String nombre){
    }
    public record ProfesionalSimpleDto(Long id, String nombre){}

    public record ConsultaSimpleDto(Long id, String observaciones, String diagnostico){}

    public static CitaDetailDto of(Cita c){
        ConsultaSimpleDto consultaDto = c.getConsulta() != null ?
                new CitaDetailDto.ConsultaSimpleDto(c.getConsulta().getId(),
                        c.getConsulta().getObservaciones(),
                        c.getConsulta().getDiagnostico()) : null;

        return new CitaDetailDto(
                c.getId(),
                c.getFechaHora(),
                c.getEstado(),
                new CitaDetailDto.PacienteSimpleDto(c.getPaciente().getId(),
                        c.getPaciente().getNombre()),
                new CitaDetailDto.ProfesionalSimpleDto(c.getProfesional().getId(),
                        c.getProfesional().getNombre()),
                consultaDto
        );
    }
}
