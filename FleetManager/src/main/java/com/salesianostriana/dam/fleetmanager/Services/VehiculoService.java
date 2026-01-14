package com.salesianostriana.dam.fleetmanager.Services;

import com.salesianostriana.dam.fleetmanager.Dtos.VehiculoDetailDto;
import com.salesianostriana.dam.fleetmanager.Models.Vehiculo;
import com.salesianostriana.dam.fleetmanager.Repositories.VehiculoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.spi.Limit;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehiculoService {
    private final VehiculoRepository vehiculoRepository;


    public List<Vehiculo> getAll(){
        List<Vehiculo>lista = vehiculoRepository.findAll();
        if (lista.isEmpty()){
            throw  new EntityNotFoundException("No hay vehículos registrados");
        }
        return lista;
    }
    public List<Vehiculo> findByEstado(String estado){
        if (!StringUtils.hasText(estado)){
            throw new IllegalArgumentException("Falta el estado");
        }
        List<Vehiculo>lista= vehiculoRepository.findByEstado(estado);
        if (lista.isEmpty()){
            throw new EntityNotFoundException("No hay vehículos con el estado "+estado);
        }
        return lista;
    }

    public Optional <VehiculoDetailDto> findVehiculoByIdWithLastMantenimiento (Long vehiculoId){
        Optional<VehiculoDetailDto> vehiculo = vehiculoRepository.findResumenById(vehiculoId);
        if (vehiculo.isEmpty()){
            throw new EntityNotFoundException("No hay vehiculo con id %d ".formatted(vehiculoId));
        }

        return vehiculo;


    }
}
