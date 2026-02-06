package com.salesianostriana.dam.fleetmanager.Services;

import com.salesianostriana.dam.fleetmanager.Models.Estado;
import com.salesianostriana.dam.fleetmanager.Models.Vehiculo;
import com.salesianostriana.dam.fleetmanager.Repositories.VehiculoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculoService {
    private final VehiculoRepository vehiculoRepository;


    public List<Vehiculo> getAll() {
        List<Vehiculo> lista = vehiculoRepository.findAll();
        if (lista.isEmpty()) {
            throw new EntityNotFoundException("No hay vehículos registrados");
        }
        return lista;
    }

    public List<Vehiculo> findByEstado(Estado estado) {
        if (estado == null) {
            throw new IllegalArgumentException("Falta el estado");
        }
        List<Vehiculo> lista = vehiculoRepository.findByEstado(estado);
        if (lista.isEmpty()) {
            throw new EntityNotFoundException("No hay vehículos con el estado " + estado);
        }
        return lista;
    }
}
