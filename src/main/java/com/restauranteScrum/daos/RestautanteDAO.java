package com.restauranteScrum.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restauranteScrum.entities.Restaurante;

@Repository
public interface RestautanteDAO extends JpaRepository<Restaurante, Integer>{

}
