package com.restauranteScrum.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restauranteScrum.daos.PersonaDAO;
import com.restauranteScrum.entities.Persona;
import com.restauranteScrum.exceptions.RestauranteException;
import com.restauranteScrum.interfaces.GeneralCrudInterface;

@Service
public class PersonaService implements GeneralCrudInterface<Persona>{
	
	 @Autowired
	 PersonaDAO personaDAO;

	@Override
	public List<Persona> obtenerTodos() throws RestauranteException {
		return this.personaDAO.findAll();
	}

	@Override
	public Persona obtenerPorId(Integer id) throws RestauranteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona eliminarPorId(Integer id) throws RestauranteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona actualizar(Persona entity, Integer id) throws RestauranteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona crear(Persona entity) throws RestauranteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Persona> crearVarios(List<Persona> personas) throws RestauranteException{
		return this.personaDAO.saveAllAndFlush(personas);
	}

	@Override
	public Persona obtenerPorNombre(String nombre) throws RestauranteException {
		// TODO Auto-generated method stub
		return null;
	}

}
