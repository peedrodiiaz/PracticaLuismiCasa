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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String matricula;
    private String modelo;
    private int kmActuales;
    private Estado estado;

    @OneToMany(mappedBy = "vehiculo",fetch = FetchType.LAZY)
    private List<Asignacion>asignaciones=new ArrayList<>();
    @OneToMany(mappedBy = "vehiculo",fetch = FetchType.LAZY)
    private List<Mantenimiento>mantenimientos=new ArrayList<>();

    public void addAsignacion(Asignacion a){
        this.asignaciones.add(a);
        a.setVehiculo(this);
    }



}
