package com.salesianostriana.dam.viviendas.dto;

import com.salesianostriana.dam.viviendas.Model.EstadoVivienda;
import com.salesianostriana.dam.viviendas.Model.TipoVivienda;
import com.salesianostriana.dam.viviendas.Model.Vivienda;

import java.time.LocalDate;

public record ViviendaReponse(
        Long id,
        String titulo,
        String ciudad,
        String provincia,
        double precio,
        double metrosCuadrados,
        int habitaciones,
        int banios,
        TipoVivienda tipo,
        EstadoVivienda estado,
        boolean disponible,
        LocalDate fechaPublicacion
) {
    public static ViviendaReponse of (Vivienda vivienda){
        return new ViviendaReponse(
                vivienda.getId(),
                vivienda.getTitulo(),
                vivienda.getCiudad(),
                vivienda.getProvincia(),
                vivienda.getPrecio(),
                vivienda.getMetrosCuadrados(),
                vivienda.getHabitaciones(),
                vivienda.getBanios(),
                vivienda.getTipo(),
                vivienda.getEstado(),
                vivienda.isDisponible(),
                vivienda.getFechaPublicacion()
        );
    }
}
