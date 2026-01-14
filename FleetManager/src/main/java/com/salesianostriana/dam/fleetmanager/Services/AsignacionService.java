package com.salesianostriana.dam.fleetmanager.Services;

import com.salesianostriana.dam.fleetmanager.Models.Asignacion;
import com.salesianostriana.dam.fleetmanager.Models.Conductor;
import com.salesianostriana.dam.fleetmanager.Models.Estado;
import com.salesianostriana.dam.fleetmanager.Models.Vehiculo;
import com.salesianostriana.dam.fleetmanager.Repositories.ConductorRepository;
import com.salesianostriana.dam.fleetmanager.Repositories.VehiculoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AsignacionService {

    private  final VehiculoRepository vehiculoRepository;
    private final ConductorRepository  conductorRepository;

    public Asignacion asignarVehiculo(Long conductorId,Long vehiculoId){
        Vehiculo vehiculo = vehiculoRepository.findById(vehiculoId).orElseThrow(
                ()-> new EntityNotFoundException("No se ha encontrado vehiculo con id ".formatted(vehiculoId))
        );
        Conductor conductor = conductorRepository.findById(conductorId).orElseThrow(
                ()-> new EntityNotFoundException("No se ha encontrado conductor con id ".formatted(conductorId))
        );

        List<Asignacion>asignaciones = vehiculo.getAsignaciones();

        if (conductor.getAsignaciones().getLast().getFechaFin()==null){
            throw new IllegalArgumentException("El conductor ya tiene una asignación");
        }
        if (vehiculo.getEstado().equals(Estado.ASIGNADO)){
            throw new IllegalArgumentException("El vehículo ya tiene una asignación");

        }

        
    }



}
