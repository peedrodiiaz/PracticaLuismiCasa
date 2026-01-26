package com.salesianostriana.dam.tiendaonline.controller;

import com.salesianostriana.dam.tiendaonline.Enum.CategoriaProducto;
import com.salesianostriana.dam.tiendaonline.dto.FilterDTO;
import com.salesianostriana.dam.tiendaonline.dto.ProductoResponse;
import com.salesianostriana.dam.tiendaonline.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
public class ProductoController {
    private final ProductoService productoService;


    @GetMapping("/api/v1/productos")
    public ResponseEntity<Page<ProductoResponse>> getAll(
                                                         @PageableDefault(size = 20, sort = "precio") Pageable pageable,
                                                         @RequestParam(required = false) String nombre,
                                                         @RequestParam(required = false) Double precioMin,
                                                         @RequestParam(required = false) Double precioMax,
                                                         @RequestParam(required = false) Integer stockMin,
                                                         @RequestParam(required = false) CategoriaProducto categoriaProducto,
                                                         @RequestParam(required = false) Boolean soloDisponible
                                                         )
    {
        FilterDTO filterDTO = new FilterDTO(nombre,precioMin,precioMax,stockMin,categoriaProducto,soloDisponible);
        return ResponseEntity.ok(
          productoService.getAll(pageable,filterDTO).map(ProductoResponse::of)
        );
    }
}
