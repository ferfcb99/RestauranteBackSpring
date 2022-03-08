package com.restauranteScrum.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.restauranteScrum.entities.Platillo;

@Repository
public interface PlatilloDAO extends JpaRepository<Platillo, Integer>{

	// select p.nombre, p.tamano, p.precio, r.nombre from Platillo p inner join Restaurante r on p.restaurante_id = r.id where r.id = 2
	// iso 2006/116
	@Query("SELECT p FROM Platillo p INNER JOIN p.restaurante r WHERE r.id = :id")
	public List<Platillo> findByIdRestaurantId(@Param("id") Integer id);
	
	
	@Query("SELECT p FROM Platillo p INNER JOIN p.tipo t WHERE t.id = :id")
	public List<Platillo> findByTipoId(@Param("id") Integer id);
}
