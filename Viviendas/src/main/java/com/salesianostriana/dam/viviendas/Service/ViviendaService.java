package com.salesianostriana.dam.viviendas.Service;

import com.salesianostriana.dam.viviendas.Model.EstadoVivienda;
import com.salesianostriana.dam.viviendas.Model.TipoVivienda;
import com.salesianostriana.dam.viviendas.Model.Vivienda;
import com.salesianostriana.dam.viviendas.dto.FilterDto;
import com.salesianostriana.dam.viviendas.repository.ViviendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.PredicateSpecification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ViviendaService {

    private final ViviendaRepository viviendaRepository;

    /*
     * ciudad String Coincidencia parcial (case-insensitive)
     * provincia String Coincidencia exacta (case-insensitive)
     * precioMin Integer precio >= precioMin
     * precioMax Integer precio <= precioMax
     * metrosMin Integer metrosCuadrados >= metrosMin
     * metrosMax Integer metrosCuadrados <= metrosMax
     * habitacionesMin Integer habitaciones >= habitacionesMin
     * banosMin Integer banos >= banosMin
     * tipo TipoVivienda Coincidencia exacta
     * estado EstadoVivienda Coincidencia exacta
     * ascensor Boolean Coincidencia exacta
     * terraza Boolean Coincidencia exacta
     * garaje Boolean Coincidencia exacta
     * soloDisponibles Boolean Si true, filtra disponible = true. Si no viene o es false, no aplica filtro
     * */
    public Page<Vivienda> getAll(Pageable pageable, FilterDto filterDto){
        PredicateSpecification<Vivienda>spec = PredicateSpecification.allOf(
                SpecificationVivienda.hasCiudad(filterDto.ciudad()),
                SpecificationVivienda.hasProvincia(filterDto.provincia()),
                SpecificationVivienda.greaterThanPrecioMin(filterDto.precioMin()),
                SpecificationVivienda.lessThanPrecioMax(filterDto.precioMax()),
                SpecificationVivienda.greaterThanMetros(filterDto.metrosMin()),
                SpecificationVivienda.lessThanMetros(filterDto.metrosMax()),
                SpecificationVivienda.greaterThanHabitaciones(filterDto.habitacionMin()),
                SpecificationVivienda.greaterThanBanios(filterDto.baniosMin()),
                SpecificationVivienda.hasTipo(filterDto.tipo()),
                SpecificationVivienda.hasEstado(filterDto.estado()),
                SpecificationVivienda.isAscensor(filterDto.ascensor()),
                SpecificationVivienda.isTerraza(filterDto.terraza()),
                SpecificationVivienda.isGaraje(filterDto.garaje()),
                SpecificationVivienda.isDiponible(filterDto.soloDisponibles())

        );
        return viviendaRepository.findBy(spec,p -> p.page(pageable));
    }

    public class SpecificationVivienda{
        public static PredicateSpecification<Vivienda>hasCiudad(String ciudad){
            return (from, criteriaBuilder) -> {
               return ciudad == null ?
                        criteriaBuilder.and()
                        : criteriaBuilder.like(criteriaBuilder.lower(from.get("ciudad")),"%"+ ciudad.toLowerCase()+"%");
            };
        };
        public static  PredicateSpecification<Vivienda>hasProvincia(String provincia){
            return (from, criteriaBuilder) -> {
                return provincia == null ?
                        criteriaBuilder.and() :
                        criteriaBuilder.equal(criteriaBuilder.lower(from.get("provincia")),provincia.toLowerCase());
            };
        }

        public static PredicateSpecification<Vivienda> greaterThanPrecioMin (Double precioMin){
            return (from, criteriaBuilder) ->
                        precioMin == null
                        ?
                        criteriaBuilder.and()
                        :
                        criteriaBuilder.greaterThanOrEqualTo(from.get("precio"),precioMin);

        }
        public static PredicateSpecification<Vivienda> lessThanPrecioMax (Double precioMax){
            return (from, criteriaBuilder) ->
                    precioMax == null
                            ?
                            criteriaBuilder.and()
                            :
                            criteriaBuilder.lessThanOrEqualTo(from.get("precio"),precioMax);

        }
        public static PredicateSpecification<Vivienda> lessThanMetros (Double metrosMax){
            return (from, criteriaBuilder) ->
                    metrosMax == null
                            ?
                            criteriaBuilder.and()
                            :
                            criteriaBuilder.lessThanOrEqualTo(from.get("metros"),metrosMax);

        }
        public static PredicateSpecification<Vivienda> greaterThanMetros(Double metrosMin){
            return (from, criteriaBuilder) ->
                    metrosMin==null
                    ? criteriaBuilder.and()
                            : criteriaBuilder.equal(from.get("metros"),metrosMin);
        }
        public static  PredicateSpecification<Vivienda> greaterThanHabitaciones (Integer habitacionesMin){
            return (from, criteriaBuilder) ->
                    habitacionesMin == null ?
                            criteriaBuilder.and()
                            : criteriaBuilder.equal(from.get("habitaciones"),habitacionesMin);

        }
        public static PredicateSpecification<Vivienda> greaterThanBanios (Integer baniosMin){
            return (from, criteriaBuilder) ->
                baniosMin==null
                        ?
                        criteriaBuilder.and()
                        : criteriaBuilder.equal(from.get("banios"), baniosMin );

        }
        public static PredicateSpecification<Vivienda> hasTipo (TipoVivienda tipo){
            return (from, criteriaBuilder) ->
                    tipo==null
                            ?
                            criteriaBuilder.and()
                            : criteriaBuilder.equal(from.get("tipo"), tipo );

        }
        public static PredicateSpecification<Vivienda> hasEstado(EstadoVivienda estadoVivienda){
            return (from, criteriaBuilder) ->
                    estadoVivienda==null
                            ?
                            criteriaBuilder.and()
                            : criteriaBuilder.equal(from.get("estado"), estadoVivienda );

        }
        public static PredicateSpecification<Vivienda> isAscensor (Boolean ascensor){
            return (from, criteriaBuilder) ->
                    ascensor==null
                            ?
                            criteriaBuilder.and()
                            : criteriaBuilder.equal(from.get("ascensor"), ascensor );

        }
        public static PredicateSpecification<Vivienda> isTerraza (Boolean terraza){
            return (from, criteriaBuilder) ->
                            terraza==null
                            ?
                            criteriaBuilder.and()
                            : criteriaBuilder.equal(from.get("terraza"), terraza );

        }

        public static PredicateSpecification<Vivienda> isGaraje (Boolean garaje){
            return (from, criteriaBuilder) ->
                    garaje==null
                            ?
                            criteriaBuilder.and()
                            : criteriaBuilder.equal(from.get("garaje"), garaje );

        }
        public static PredicateSpecification  <Vivienda> isDiponible (Boolean disponible){
            return (from, criteriaBuilder) ->
                    disponible ==null ? criteriaBuilder.and()
                            : criteriaBuilder.equal(from.get("diponible"),disponible);
        }














    }
}
