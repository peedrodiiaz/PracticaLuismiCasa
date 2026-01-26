package com.salesianostriana.dam.viviendas.dto;

import com.salesianostriana.dam.viviendas.Model.EstadoVivienda;
import com.salesianostriana.dam.viviendas.Model.TipoVivienda;
import org.springframework.web.bind.annotation.RequestParam;

public record FilterDto(
        String ciudad,
        String provincia,
        double precioMin,
        double precioMax,
        double metrosMin,
        double metrosMax,
        int habitacionMin,
        int baniosMin,
        TipoVivienda tipo,
        EstadoVivienda estado,
        boolean ascensor,
        boolean terraza,
        boolean garaje,
        boolean soloDisponibles
) {
}
