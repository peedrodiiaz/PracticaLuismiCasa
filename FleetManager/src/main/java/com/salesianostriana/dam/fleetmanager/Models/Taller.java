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
public class Taller {

    @Id@GeneratedValue
    private  Long id;
    private String nombre;
    private String ciudad;

    @OneToMany(mappedBy = "taller", fetch = FetchType.LAZY)
    private List<Mantenimiento>mantenimientos= new ArrayList<>();


}
