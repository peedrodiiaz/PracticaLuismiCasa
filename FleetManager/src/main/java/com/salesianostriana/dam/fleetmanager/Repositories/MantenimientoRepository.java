package com.salesianostriana.dam.fleetmanager.Repositories;

import com.salesianostriana.dam.fleetmanager.Models.Mantenimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MantenimientoRepository extends JpaRepository <Mantenimiento,Long> {
    List<Mantenimiento> findMantenimientosByVehiculoId (Long vehiculoId);

    @Query("select m from Mantenimiento m where m.vehiculo.id = ?1 order by m.fecha DESC LIMIT 1")
    Optional<Mantenimiento> findFirstByVehiculo_IdOrderByFechaDesc(Long id);


}
