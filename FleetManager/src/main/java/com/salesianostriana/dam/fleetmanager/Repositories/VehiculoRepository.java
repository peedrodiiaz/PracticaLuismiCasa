package com.salesianostriana.dam.fleetmanager.Repositories;

import com.salesianostriana.dam.fleetmanager.Models.Estado;
import com.salesianostriana.dam.fleetmanager.Models.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehiculoRepository extends JpaRepository <Vehiculo,Long> {

        List<Vehiculo> findByEstado(Estado estado);

}
