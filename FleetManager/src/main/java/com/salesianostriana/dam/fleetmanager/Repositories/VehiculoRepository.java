package com.salesianostriana.dam.fleetmanager.Repositories;

import com.salesianostriana.dam.fleetmanager.Models.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculoRepository extends JpaRepository <Vehiculo,Long> {
}
