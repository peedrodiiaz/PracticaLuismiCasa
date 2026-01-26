package com.salesianostriana.dam.tiendaonline.service;

import com.salesianostriana.dam.tiendaonline.Enum.CategoriaProducto;
import com.salesianostriana.dam.tiendaonline.Model.Producto;
import com.salesianostriana.dam.tiendaonline.Repository.ProductoRepository;
import com.salesianostriana.dam.tiendaonline.dto.FilterDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.PredicateSpecification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;

    public Page<Producto>getAll (Pageable pageable, FilterDTO filterDTO){
        PredicateSpecification<Producto> specification = PredicateSpecification.allOf(
                ProductoSpecifications.hasName(filterDTO.name()),
                ProductoSpecifications.greaterThanPrecioMin(filterDTO.precioMin()),
                ProductoSpecifications.lessThanPrecioMax(filterDTO.precioMax()),
                ProductoSpecifications.greaterThanStockMin(filterDTO.stockMin()),
                ProductoSpecifications.hasCategoria(filterDTO.categoriaProducto()),
                ProductoSpecifications.isDisponible(filterDTO.soloDisponibles())
        );

        if (filterDTO.precioMin()!=null && filterDTO.precioMax()!=null){
            if (filterDTO.precioMin()> filterDTO.precioMax())
                throw new IllegalArgumentException("El precio mínimo no puede ser mayor al máximo");
            if (pageable.getPageSize()>50)
                throw new IllegalArgumentException("La paginacion no puede ser tan grande");
        }

        return productoRepository.findBy(specification,p -> p.page(pageable));

    }

    public static class ProductoSpecifications{
        public static PredicateSpecification<Producto> hasName (String name){
            return (from, criteriaBuilder) ->
                    name == null  ?
                            criteriaBuilder.and() : criteriaBuilder.like(from.get("nombre"),"%"+name+"%");
        }
        public static PredicateSpecification<Producto> greaterThanPrecioMin (Double precioMin){
            return (from, criteriaBuilder) ->
                    precioMin == null  ?
                            criteriaBuilder.and() : criteriaBuilder.greaterThanOrEqualTo(from.get("precio"),precioMin);
        }
        public static PredicateSpecification<Producto> lessThanPrecioMax (Double precioMax){
            return (from, criteriaBuilder) ->
                    precioMax == null  ?
                            criteriaBuilder.and() : criteriaBuilder.lessThanOrEqualTo(from.get("precio"),precioMax);
        }
        public static PredicateSpecification<Producto> greaterThanStockMin (Integer stockMin){
            return (from, criteriaBuilder) ->
                    stockMin == null  ?
                            criteriaBuilder.and() : criteriaBuilder.greaterThanOrEqualTo(from.get("stock"),stockMin);
        }
        public static PredicateSpecification <Producto> hasCategoria (CategoriaProducto categoria){
            return (from, criteriaBuilder) ->
                    categoria==null ? criteriaBuilder.and()
                            : criteriaBuilder.equal(from.get("categoria"), categoria);
        }
        public static PredicateSpecification <Producto> isDisponible (Boolean disponible){
            return (from, criteriaBuilder) ->
                    disponible == null ?
                            criteriaBuilder.and():
                            criteriaBuilder.equal(from.get("disponible"),disponible);

        }


    }
}
