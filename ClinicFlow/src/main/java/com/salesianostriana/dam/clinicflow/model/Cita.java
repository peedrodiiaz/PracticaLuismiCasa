package com.salesianostriana.dam.clinicflow.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Cita {

    @Id@GeneratedValue
    private Long id;
    private LocalDateTime fechaHora;
    private  Estado estado;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "profesional_id")
    private Profesional profesional;


    @OneToOne
    @JoinColumn(name = "consulta_id")
    private Consulta consulta;

}
