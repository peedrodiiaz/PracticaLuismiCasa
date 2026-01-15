package com.salesianostriana.dam.clinicflow.repository;

import com.salesianostriana.dam.clinicflow.model.Cita;
import com.salesianostriana.dam.clinicflow.model.Profesional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ProfesionalRepository extends JpaRepository<Profesional,Long> {


    boolean existsByIdAndCitas_FechaHora(Long id, LocalDateTime fechaHora);
}
