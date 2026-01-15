package com.salesianostriana.dam.clinicflow.service;

import com.salesianostriana.dam.clinicflow.dto.CitaListDto;
import com.salesianostriana.dam.clinicflow.dto.CreateCitaRequest;
import com.salesianostriana.dam.clinicflow.dto.CreateConsultaRequest;
import com.salesianostriana.dam.clinicflow.model.*;
import com.salesianostriana.dam.clinicflow.repository.CitaRepository;
import com.salesianostriana.dam.clinicflow.repository.ConsultaRepository;
import com.salesianostriana.dam.clinicflow.repository.PacienteRepository;
import com.salesianostriana.dam.clinicflow.repository.ProfesionalRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CitaService {
    private final ConsultaRepository consultaRepository;
    private final PacienteRepository pacienteRepository;
    private final ProfesionalRepository profesionalRepository;
    private final CitaRepository citaRepository;


    public Cita createCita (CreateCitaRequest dto){

        Paciente paciente = pacienteRepository.findById(dto.pacienteId()).orElseThrow(
                ()-> new EntityNotFoundException("No se ha encontrado el paciente con id %d".formatted(dto.pacienteId()))
        );
        Profesional profesional = profesionalRepository.findById(dto.profesionalId()).orElseThrow(
                ()-> new EntityNotFoundException("No se ha encontrado el profesional con id %d".formatted(dto.profesionalId()))
        );

        if (profesionalRepository.existsByIdAndCitas_FechaHora(dto.profesionalId(), dto.fechaHora()))
            throw  new IllegalArgumentException("El profesional no puede tener dos citas en la misma fecha y hora");

        if (pacienteRepository.existsByIdAndCitas_FechaHoraBetween(dto.pacienteId(), LocalDateTime.now(),dto.fechaHora()))
            throw  new IllegalArgumentException("El paciente no puede tener citas en el mismo día");

        if (dto.fechaHora().isBefore(LocalDateTime.now()))
            throw  new IllegalArgumentException("No se pueden crear citas en el pasado");


        return citaRepository.save(Cita.builder()
                .fechaHora(dto.fechaHora())
                .paciente(paciente)
                .profesional(profesional)
                .estado(Estado.PROGRAMADA)
                .build());

    }

    public Cita cancelarCita (Long citaId){
        Cita cita = citaRepository.findById(citaId).orElseThrow(
                ()-> new EntityNotFoundException("No se ha encontrado la cita con id %d".formatted(citaId))
        );

        if (cita.getEstado()==Estado.ATENDIDA)
            throw new IllegalArgumentException("No se puede cancelar la cita porque esta atendida");

        cita.setEstado(Estado.CANCELADA);

       return citaRepository.save(cita);


    }
    public Cita createConsulta(CreateConsultaRequest dto, Long citaId) {


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
        return  c;
    }


    public Page <Cita> getAll (Pageable pageable){
        return citaRepository.pageFindAll(pageable);
    }




}
