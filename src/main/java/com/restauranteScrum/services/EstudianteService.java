package com.restauranteScrum.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restauranteScrum.daos.EstudianteDao;
import com.restauranteScrum.entities.Estudiante;
import com.restauranteScrum.exceptions.RestauranteException;

@Service
public class EstudianteService {

	@Autowired
	EstudianteDao estudianteDao;
	
	public List<Estudiante> obtenerTodos() throws RestauranteException{
		return this.estudianteDao.findAll();
	}
	
	public List<Estudiante> crearVarios(List<Estudiante> estudiantes) throws RestauranteException{
		return this.estudianteDao.saveAllAndFlush(estudiantes);
	}
	
}
