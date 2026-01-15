package com.salesianostriana.dam.clinicflow.repository;

import com.salesianostriana.dam.clinicflow.model.Cita;
import com.salesianostriana.dam.clinicflow.model.Estado;
import com.salesianostriana.dam.clinicflow.model.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface CitaRepository extends JpaRepository<Cita,Long> {


    @EntityGraph (attributePaths = {"paciente"})
    List<Cita> findByPaciente(Paciente paciente);

    List<Cita> findByEstado(Estado estado);

    List<Cita> findByFechaHoraBetween(LocalDateTime fechaHoraStart, LocalDateTime fechaHoraEnd);

    @EntityGraph (attributePaths = {"profesional","paciente"})
    @Query("select c from Cita c where c.profesional.id = ?1 and c.paciente.nombre = ?2")
    List<Cita> findByProfesional_IdAndPaciente_Nombre(Long id, String nombre);

    @EntityGraph (attributePaths = {"paciente", "profesional", "consulta"})
    @Query("select c from Cita c")
    Page<Cita> pageFindAll(Pageable pageable);


}
