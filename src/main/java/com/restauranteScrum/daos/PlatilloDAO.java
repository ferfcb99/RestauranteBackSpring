package com.restauranteScrum.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restauranteScrum.entities.Platillo;

@Repository
public interface PlatilloDAO extends JpaRepository<Platillo, Integer>{

}
