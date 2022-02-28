package com.restauranteScrum.interfaces;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.restauranteScrum.exceptions.RestauranteException;


public interface GeneralCrudInterface<T> {

	public List<T> obtenerTodos() throws RestauranteException;
	
	public T obtenerPorId(@PathVariable Integer id) throws RestauranteException;
	
	public T eliminarPorId(@PathVariable Integer id) throws RestauranteException;
	
	public T actualizar(@RequestBody T entity, @PathVariable Integer id) throws RestauranteException;
	
	public T crear(@RequestBody T entity) throws RestauranteException;
	
}
