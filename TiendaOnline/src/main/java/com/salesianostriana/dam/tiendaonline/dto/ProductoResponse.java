package com.salesianostriana.dam.tiendaonline.dto;

import com.salesianostriana.dam.tiendaonline.Enum.CategoriaProducto;
import com.salesianostriana.dam.tiendaonline.Model.Producto;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;

import java.time.LocalDate;

public record ProductoResponse(
        String nombre,
        double precio,
        int stock,
        CategoriaProducto categoria,
        boolean disponible,
        LocalDate fechaAlta
) {
    public static ProductoResponse of (Producto p){
        return new ProductoResponse(
                p.getNombre(),
                p.getPrecio(),
                p.getStock(),
                p.getCategoria(),
                p.isDisponible(),
                p.getFechaAlta()
        );

    }
}
