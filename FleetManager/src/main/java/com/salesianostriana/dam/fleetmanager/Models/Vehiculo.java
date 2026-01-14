package com.salesianostriana.dam.fleetmanager.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter@Setter
public class Vehiculo {
    @Id@GeneratedValue
    private Long id;

    private String matricula;
    private String modelo;
    private int kmActuales;
    private Estado estado;

    @OneToMany(mappedBy = "vehiculo",fetch = FetchType.LAZY)
    private List<Asignacion>asignaciones=new ArrayList<>();
    @OneToMany(mappedBy = "vehiculo",fetch = FetchType.LAZY)
    private List<Mantenimiento>mantenimientos=new ArrayList<>();



}
