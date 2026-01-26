package com.salesianostriana.dam.tiendaonline.Model;

import com.salesianostriana.dam.tiendaonline.Enum.CategoriaProducto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter @ToString
@Table (name = "productos")
public class Producto {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (nullable = false)
    private String nombre;
    @Column (nullable = false)
    @Lob
    private String descripcion;
    @Column (nullable = false)
    private double precio;
    @Column (nullable = false)
    private int stock;
    @Enumerated (EnumType.STRING)
    private CategoriaProducto categoria;

    private boolean disponible;
    private LocalDate fechaAlta;



}
