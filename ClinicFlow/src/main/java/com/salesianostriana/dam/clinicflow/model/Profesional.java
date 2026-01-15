package com.salesianostriana.dam.clinicflow.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Profesional {

    @Id@GeneratedValue
    private Long id;
    private String nombre;
    private String especialidad;
    @OneToMany(mappedBy = "profesional", fetch = FetchType.LAZY)
    private List<Cita>citas=new ArrayList<>();

}
