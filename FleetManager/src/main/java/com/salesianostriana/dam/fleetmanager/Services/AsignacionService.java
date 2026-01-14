package com.salesianostriana.dam.fleetmanager.Services;

import com.salesianostriana.dam.fleetmanager.Models.Asignacion;
import com.salesianostriana.dam.fleetmanager.Models.Conductor;
import com.salesianostriana.dam.fleetmanager.Models.Estado;
import com.salesianostriana.dam.fleetmanager.Models.Vehiculo;
import com.salesianostriana.dam.fleetmanager.Repositories.AsignacionRepository;
import com.salesianostriana.dam.fleetmanager.Repositories.ConductorRepository;
import com.salesianostriana.dam.fleetmanager.Repositories.VehiculoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AsignacionService {

    private final VehiculoRepository vehiculoRepository;
    private final ConductorRepository conductorRepository;
    private final AsignacionRepository asignacionRepository;

    @Transactional
    public Asignacion asignarVehiculo(Long conductorId, Long vehiculoId) {
        Vehiculo vehiculo = vehiculoRepository.findById(vehiculoId).orElseThrow(
                ()-> new EntityNotFoundException("No se ha encontrado vehiculo con id %d ".formatted(vehiculoId))
        );
        Conductor conductor = conductorRepository.findById(conductorId).orElseThrow(
                ()-> new EntityNotFoundException("No se ha encontrado conductor con id %d".formatted(conductorId))
        );

        if (!conductor.getAsignaciones().isEmpty() && conductor.getAsignaciones().getLast().getFechaFin() == null) {
            throw new IllegalArgumentException("El conductor ya tiene una asignación activa");
        }

        if (vehiculo.getEstado().equals(Estado.ASIGNADO)) {
            throw new IllegalArgumentException("El vehículo ya tiene una asignación");
        }

        Asignacion asignacion = Asignacion.builder()
                .fechaInicio(LocalDate.now())
                .conductor(conductor)
                .vehiculo(vehiculo)
                .build();
        conductor.aniadirAsignacion(asignacion);
        vehiculo.addAsignacion(asignacion);
        vehiculo.setEstado(Estado.ASIGNADO);

        return asignacionRepository.save(asignacion);



    }

    @Transactional
    public Asignacion finalizarAsignacion (Long conductorId, Long vehiculoId, Long asignacionId){
        Vehiculo vehiculo = vehiculoRepository.findById(vehiculoId).orElseThrow(
                ()-> new EntityNotFoundException("No se ha encontrado vehiculo con id ".formatted(vehiculoId))
        );
        Conductor conductor = conductorRepository.findById(conductorId).orElseThrow(
                ()-> new EntityNotFoundException("No se ha encontrado conductor con id ".formatted(conductorId))
        );
        Asignacion asignacion = asignacionRepository.findById(asignacionId).orElseThrow(
                ()-> new EntityNotFoundException("No se ha encontrado conductor con id ".formatted(conductorId))
        );

        if (vehiculo.getEstado().equals(Estado.DISPONIBLE) || vehiculo.getEstado().equals(Estado.EN_MANTENIMIENTO)) {
            throw new IllegalArgumentException("El vehículo no estaba asignado");
        }

        if (!Objects.equals(asignacion.getConductor().getId(), conductorId) || !Objects.equals(asignacion.getVehiculo().getId(), vehiculoId)){
            throw new IllegalArgumentException("Esta asignación no corresponde con este conductor y vehiculo");
        }

        asignacion.setFechaFin(LocalDate.now());
        vehiculo.setEstado(Estado.DISPONIBLE);
        asignacionRepository.save(asignacion);

        return asignacion;


    }


    public List <Asignacion> getAll (){
        List<Asignacion>lista= asignacionRepository.findAll();

        if (lista.isEmpty())
            throw new EntityNotFoundException("No hay asignaciones guardadas");

        return lista;

    }
}
