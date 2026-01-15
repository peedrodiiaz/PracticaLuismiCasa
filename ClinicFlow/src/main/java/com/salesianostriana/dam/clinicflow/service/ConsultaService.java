package com.salesianostriana.dam.clinicflow.service;

import com.salesianostriana.dam.clinicflow.dto.CreateConsultaRequest;
import com.salesianostriana.dam.clinicflow.model.Cita;
import com.salesianostriana.dam.clinicflow.model.Consulta;
import com.salesianostriana.dam.clinicflow.model.Estado;
import com.salesianostriana.dam.clinicflow.repository.CitaRepository;
import com.salesianostriana.dam.clinicflow.repository.ConsultaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final CitaRepository citaRepository;

    public Consulta createConsulta(CreateConsultaRequest dto, Long citaId) {


        Cita c = citaRepository.findById(citaId).orElseThrow(
                () -> new EntityNotFoundException("No se ha encontrado la cita con id %d".formatted(citaId))
        );

        if (c.getEstado() != Estado.PROGRAMADA)
            throw new IllegalArgumentException("No se puede crear la consulta porque no hay cita programada");

        Consulta consulta = Consulta.builder()
                .fecha(dto.fecha())
                .observaciones(dto.observaciones())
                .diagnostico(dto.diagnostico())
                .cita(c)
                .build();

        c.setConsulta(consulta);
        c.setEstado(Estado.ATENDIDA);
        citaRepository.save(c);
        consultaRepository.save(consulta);
        return  consulta;
    }
}
