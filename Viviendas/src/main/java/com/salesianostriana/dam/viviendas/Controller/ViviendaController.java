package com.salesianostriana.dam.viviendas.Controller;

import com.salesianostriana.dam.viviendas.Model.EstadoVivienda;
import com.salesianostriana.dam.viviendas.Model.TipoVivienda;
import com.salesianostriana.dam.viviendas.Model.Vivienda;
import com.salesianostriana.dam.viviendas.Service.ViviendaService;
import com.salesianostriana.dam.viviendas.dto.FilterDto;
import com.salesianostriana.dam.viviendas.dto.ViviendaReponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ViviendaController {
    private final ViviendaService viviendaService;


    @GetMapping ("/api/v1/viviendas")
    public ResponseEntity <Page<ViviendaReponse>> getAll( @PageableDefault (size = 20,page = 0) Pageable pageable,
                                                  @RequestParam(required=false) String ciudad,
                                                  @RequestParam(required=false) String provincia,
                                                  @RequestParam(required=false) double precioMin,
                                                  @RequestParam(required=false) double precioMax,
                                                  @RequestParam(required=false) double metrosMin,
                                                  @RequestParam(required=false) double metrosMax,
                                                  @RequestParam(required=false) int habitacionMin,
                                                  @RequestParam(required=false) int bonosMin,
                                                  @RequestParam(required=false) TipoVivienda tipo,
                                                  @RequestParam(required=false)EstadoVivienda estado,
                                                  @RequestParam(required=false)boolean ascensor,
                                                  @RequestParam(required=false)boolean terraza,
                                                  @RequestParam(required=false)boolean garaje,
                                                  @RequestParam(required=false)boolean soloDisponibles


                                                  ){
        FilterDto filterDto = new FilterDto(ciudad,provincia,precioMin,precioMax,metrosMin,metrosMax,habitacionMin,bonosMin,tipo,estado,ascensor,terraza,garaje,soloDisponibles);
        return ResponseEntity.ok(
          viviendaService.getAll(
                  pageable, filterDto).map(ViviendaReponse::of)
        );
    }

}
