package com.restauranteScrum.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restauranteScrum.entities.Persona;

@Repository
public interface PersonaDAO extends JpaRepository<Persona, Integer>{
	
	

}
