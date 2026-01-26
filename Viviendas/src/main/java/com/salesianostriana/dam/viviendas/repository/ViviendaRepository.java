package com.salesianostriana.dam.viviendas.repository;

import com.salesianostriana.dam.viviendas.Model.Vivienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ViviendaRepository extends JpaRepository<Vivienda,Long> , JpaSpecificationExecutor<Vivienda> {
}
