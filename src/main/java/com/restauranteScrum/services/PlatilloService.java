package com.restauranteScrum.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restauranteScrum.daos.PlatilloDAO;
import com.restauranteScrum.entities.Platillo;
import com.restauranteScrum.exceptions.NotFoundException;
import com.restauranteScrum.exceptions.RestauranteException;
import com.restauranteScrum.interfaces.GeneralCrudInterface;

@Service
public class PlatilloService implements GeneralCrudInterface<Platillo>{
	
	@Autowired
	PlatilloDAO platilloDAO;

	@Override
	public List<Platillo> obtenerTodos() throws RestauranteException {
		return this.platilloDAO.findAll();
	}

	@Override
	public Platillo obtenerPorId(Integer id) throws RestauranteException {
		Platillo platillo = this.platilloDAO.findById(id).orElseThrow(() -> new NotFoundException("Error", "Elemento con el id: " + id + "No encontrado"));
		return platillo;
	}

	@Override
	public Platillo eliminarPorId(Integer id) throws RestauranteException {
		// buscamos el platillo
		Platillo platillo = this.platilloDAO.findById(id).orElseThrow(() -> new NotFoundException("Error", "Elemento con el id: " + id + "No encontrado"));
		// eliminar platillo
		this.platilloDAO.deleteById(id);
		// retornamos
		return platillo;
	}

	@Override
	public Platillo actualizar(Platillo entity, Integer id) throws RestauranteException {
		Platillo platillo = this.platilloDAO.findById(id).orElseThrow(() -> new NotFoundException("Error", "Elemento con el id: " + id + "No encontrado"));
		
		platillo.setNombre(entity.getNombre());
		platillo.setPrecio(entity.getPrecio());
		platillo.setRestaurante(entity.getRestaurante());
		platillo.setTamano(entity.getTamano());
		platillo.setTipo(entity.getTipo());
		
		return this.platilloDAO.save(platillo);		
		
	}

	@Override
	public Platillo crear(Platillo entity) throws RestauranteException {
		return this.platilloDAO.save(entity);
	}

}
