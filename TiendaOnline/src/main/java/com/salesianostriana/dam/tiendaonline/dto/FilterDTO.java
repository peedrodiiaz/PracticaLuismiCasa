package com.salesianostriana.dam.tiendaonline.dto;

import com.salesianostriana.dam.tiendaonline.Enum.CategoriaProducto;

public record FilterDTO(
        String name,
        Double precioMin,
        Double precioMax,
        Integer stockMin,
        CategoriaProducto categoriaProducto,
        Boolean soloDisponibles
        ) {
}
