package com.restauranteScrum.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restauranteScrum.entities.Tipo;

@Repository
public interface TipoDAO extends JpaRepository<Tipo, Integer>{

}
