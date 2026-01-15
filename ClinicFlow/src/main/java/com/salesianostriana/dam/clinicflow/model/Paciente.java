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
@Getter @Setter
public class Paciente {
    @Id@GeneratedValue
    private Long id;
    private String nombre;
    private String email;
    private LocalDate fechaNacimiento;
    @OneToMany (mappedBy = "paciente", fetch = FetchType.LAZY)
    private List <Cita> citas = new ArrayList<>();

}
