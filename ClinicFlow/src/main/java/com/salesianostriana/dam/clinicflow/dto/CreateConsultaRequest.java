package com.salesianostriana.dam.clinicflow.dto;

import com.salesianostriana.dam.clinicflow.model.Cita;

import java.time.LocalDate;
import java.util.List;

public record CreateConsultaRequest(
        String observaciones,
        String diagnostico,
        LocalDate fecha
) {
}
