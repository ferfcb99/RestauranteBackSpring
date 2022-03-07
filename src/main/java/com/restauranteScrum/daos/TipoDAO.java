package com.restauranteScrum.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.restauranteScrum.entities.Tipo;

@Repository
public interface TipoDAO extends JpaRepository<Tipo, Integer>{

	// consulta (sql) en formato HQL
	
	@Query("SELECT t FROM Tipo t WHERE t.nombre = :nombre")
	public Tipo findByNombre(@Param("nombre") String nombre);
	
}
