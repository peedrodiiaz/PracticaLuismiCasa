package com.salesianostriana.dam.viviendas.Model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
@Table(name = "Viviendas")
public class Vivienda {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String titulo;
    @Lob
    private String descripcion;
    @Column (nullable = false)
    private String ciudad;
    @Column (nullable = false)
    private String provincia;
    private double precio;
    private double metrosCuadrados;
    private int habitaciones;
    private int banios;

    @Enumerated(EnumType.STRING)
    private TipoVivienda tipo;
    @Enumerated (EnumType.STRING)
    private EstadoVivienda estado;

    private boolean ascensor;
    private boolean terraza;
    private boolean garaje;
    private boolean disponible;
    private LocalDate fechaPublicacion;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Vivienda vivienda = (Vivienda) o;
        return getId() != null && Objects.equals(getId(), vivienda.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
