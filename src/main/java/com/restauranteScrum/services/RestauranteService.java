package com.restauranteScrum.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restauranteScrum.daos.RestautanteDAO;
import com.restauranteScrum.entities.Restaurante;
import com.restauranteScrum.exceptions.NotFoundException;
import com.restauranteScrum.exceptions.RestauranteException;
import com.restauranteScrum.interfaces.GeneralCrudInterface;

@Service
public class RestauranteService implements GeneralCrudInterface<Restaurante>{
	
	@Autowired
	RestautanteDAO restauranteDAO;

	@Override
	public List<Restaurante> obtenerTodos() throws RestauranteException {
		return this.restauranteDAO.findAll();
	}

	@Override
	public Restaurante obtenerPorId(Integer id) throws RestauranteException {
		return this.restauranteDAO.findById(id)
				.orElseThrow(() -> new NotFoundException("Error", "Elemento no encontrado - ID: " + id));
	}

	@Override
	public Restaurante eliminarPorId(Integer id) throws RestauranteException {
		try {
			Restaurante restauranteEliminar = obtenerPorId(id);
			
			this.restauranteDAO.deleteById(id);
			
			return restauranteEliminar;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public Restaurante actualizar(Restaurante entity, Integer id) throws RestauranteException {
		try {
			Restaurante restauranteActualizar = obtenerPorId(id);
			
			restauranteActualizar.setNombre(entity.getNombre());
			restauranteActualizar.setTipo(entity.getTipo());
			
			return this.restauranteDAO.save(restauranteActualizar);
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public Restaurante crear(Restaurante entity) throws RestauranteException {
		return this.restauranteDAO.save(entity);
	}

	@Override
	public Restaurante obtenerPorNombre(String nombre) throws RestauranteException {
		// TODO Auto-generated method stub
		return null;
	}

}
