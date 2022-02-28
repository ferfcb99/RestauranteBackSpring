package com.restauranteScrum.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restauranteScrum.daos.TipoDAO;
import com.restauranteScrum.entities.Tipo;
import com.restauranteScrum.exceptions.NotFoundException;
import com.restauranteScrum.exceptions.RestauranteException;
import com.restauranteScrum.interfaces.GeneralCrudInterface;

@Service
public class TipoService implements GeneralCrudInterface<Tipo> {

	@Autowired
	TipoDAO tipoDAO;

	@Override
	public List<Tipo> obtenerTodos() throws RestauranteException {
		return tipoDAO.findAll();
	}

	@Override
	public Tipo obtenerPorId(Integer id) throws RestauranteException {
		return tipoDAO.findById(id)
				.orElseThrow(() -> new NotFoundException("Error", "Elemento no encontrado - ID: " + id));
	}

	@Override
	public Tipo eliminarPorId(Integer id) throws RestauranteException{
		try {
			Tipo tipoAEliminar = obtenerPorId(id);
			tipoDAO.deleteById(id);
			return tipoAEliminar;
		}catch(NotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Tipo actualizar(Tipo entity, Integer id) throws RestauranteException {
		Tipo tipo = new Tipo();
		try {
			tipo = obtenerPorId(id);
			tipo.setNombre(entity.getNombre());
			
			return this.tipoDAO.save(tipo);
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public Tipo crear(Tipo entity) throws RestauranteException {
		return this.tipoDAO.save(entity);
	}

}
