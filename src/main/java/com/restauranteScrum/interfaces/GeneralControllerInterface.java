package com.restauranteScrum.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.restauranteScrum.exceptions.RestauranteException;
import com.restauranteScrum.publics.Response;

public interface GeneralControllerInterface<T> {

	// responseEntity<Reponse<T>>
	
	public ResponseEntity<Response<List<T>>> obtenerTodos() throws RestauranteException;
	
	public ResponseEntity<Response<T>> obtenerPorId(@PathVariable Integer id) throws RestauranteException;
	
	public ResponseEntity<Response<T>> crear(@RequestBody T entity) throws RestauranteException;
	
	// eliminar y actualizar
	
	public ResponseEntity<Response<T>> eliminar(@PathVariable Integer id) throws RestauranteException;
	
	public ResponseEntity<Response<T>> actualizar(@RequestBody T entity, @PathVariable Integer id) throws RestauranteException;
	
}
