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

    @Id@GeneratedValue
    private Long id;
    private String nombre;
    private String email;

    @OneToMany (mappedBy = "conductor", fetch = FetchType.LAZY)
    private List<Asignacion>asignaciones = new ArrayList<>();

    public void aniadirAsigancion(){
        if (asignaciones!=null){
            asignaciones.
        }
    }
}
