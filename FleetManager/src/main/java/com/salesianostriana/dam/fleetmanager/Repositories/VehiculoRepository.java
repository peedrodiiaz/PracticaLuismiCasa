package com.salesianostriana.dam.fleetmanager.Repositories;

import com.salesianostriana.dam.fleetmanager.Dtos.VehiculoDetailDto;
import com.salesianostriana.dam.fleetmanager.Dtos.VehiculoSummaryDto;
import com.salesianostriana.dam.fleetmanager.Models.Mantenimiento;
import com.salesianostriana.dam.fleetmanager.Models.Vehiculo;
import org.hibernate.query.spi.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface VehiculoRepository extends JpaRepository <Vehiculo,Long> {

        List<Vehiculo> findByEstado(String estado);

        @Query("select new com.ejemplo.VehiculoResumenDTO(v.id, v.marca, " +
            "(select m from Mantenimiento m where m.vehiculo = v order by m.fecha DESC limit 1)) " +
            "from Vehiculo v where v.id = ?1")
        Optional<VehiculoDetailDto> findResumenById(Long id);
}
