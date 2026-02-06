package com.salesianostriana.dam.fleetmanager.Models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Mantenimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private LocalDate fecha;
    private int kmEnRevision;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculo;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "taller_id")
    private Taller taller;

}