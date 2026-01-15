package com.salesianostriana.dam.clinicflow.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Consulta {
    @Id@GeneratedValue
    private Long id;
    private String observaciones;
    private String diagnostico;
    private LocalDate fecha;

    @OneToOne (mappedBy = "consulta")
    private Cita cita;

}
