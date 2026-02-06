package com.salesianostriana.dam.fleetmanager.Repositories;

import com.salesianostriana.dam.fleetmanager.Models.Mantenimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MantenimientoRepository extends JpaRepository <Mantenimiento,Long> {


}
