package com.salesianostriana.dam.clinicflow.repository;

import com.salesianostriana.dam.clinicflow.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface PacienteRepository extends JpaRepository<Paciente,Long> {


    boolean existsByIdAndCitas_FechaHoraBetween(Long id, LocalDateTime fechaHoraStart, LocalDateTime fechaHoraEnd);
}
