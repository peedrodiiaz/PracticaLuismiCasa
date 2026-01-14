package com.salesianostriana.dam.fleetmanager.Repositories;

import com.salesianostriana.dam.fleetmanager.Models.Conductor;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConductorRepository extends JpaRepository<Conductor,Long> {

    @EntityGraph(attributePaths = {"asignaciones"})
    Optional<Conductor>findWithAsignacionesById(Long id);
}
