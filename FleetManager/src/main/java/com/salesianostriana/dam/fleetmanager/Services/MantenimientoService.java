package com.salesianostriana.dam.fleetmanager.Services;

import com.salesianostriana.dam.fleetmanager.Dto.CreateMantenimientoRequest;
import com.salesianostriana.dam.fleetmanager.Models.Estado;
import com.salesianostriana.dam.fleetmanager.Models.Mantenimiento;
import com.salesianostriana.dam.fleetmanager.Models.Taller;
import com.salesianostriana.dam.fleetmanager.Models.Vehiculo;
import com.salesianostriana.dam.fleetmanager.Repositories.MantenimientoRepository;
import com.salesianostriana.dam.fleetmanager.Repositories.TallerRepository;
import com.salesianostriana.dam.fleetmanager.Repositories.VehiculoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MantenimientoService {
    private final VehiculoRepository vehiculoRepository;
    private final TallerRepository tallerRepository;
    private final MantenimientoRepository mantenimientoRepository;
    public Mantenimiento registrarMantenimiento (CreateMantenimientoRequest mantenimientoSummaryDto){
        Vehiculo vehiculo = vehiculoRepository.findById(mantenimientoSummaryDto.idVehiculo()).orElseThrow(
                ()-> new EntityNotFoundException("No se ha encontrado el vehiculo con id %d". formatted(mantenimientoSummaryDto.idVehiculo()))
        );
        Taller taller= tallerRepository.findById(mantenimientoSummaryDto.idTaller()).orElseThrow(
                ()-> new EntityNotFoundException("No se ha encontrado al vehiculo con id %d".formatted(mantenimientoSummaryDto.idTaller()))
        );
//        if (mantenimientoSummaryDto.kmEnRevision()<= vehiculo.getKmActuales())
//            throw  new IllegalArgumentException("No se puede hacer el mantenimiento porque se pasa de kilometros el coche");


        if (vehiculo.getEstado().equals(Estado.ASIGNADO))
            throw  new IllegalArgumentException("No se puede hacer un mantenimiento a un vehiculo asignado");



        Mantenimiento m = Mantenimiento.builder()
                .tipo(mantenimientoSummaryDto.tipo())
                .fecha(mantenimientoSummaryDto.fecha())
                .kmEnRevision(mantenimientoSummaryDto.kmEnRevision())
                .vehiculo(vehiculo)
                .taller(taller)
                .build();

        mantenimientoRepository.save(m);

        return m;
    }

}
