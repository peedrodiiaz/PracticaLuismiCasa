package com.salesianostriana.dam.fleetmanager.Models;

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
public class Conductor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;

    @OneToMany (mappedBy = "conductor", fetch = FetchType.LAZY)
    private List<Asignacion>asignaciones = new ArrayList<>();

    public void aniadirAsignacion(Asignacion a){
        this.asignaciones.add(a);
        a.setConductor(this);
    }
}
