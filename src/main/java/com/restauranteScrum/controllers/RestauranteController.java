package com.restauranteScrum.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.restauranteScrum.entities.Restaurante;
import com.restauranteScrum.exceptions.RestauranteException;
import com.restauranteScrum.interfaces.GeneralControllerInterface;
import com.restauranteScrum.publics.Response;
import com.restauranteScrum.services.RestauranteService;

// http://localhost:8084/api/v1

@RestController
@RequestMapping(value = "/api/v1/restaurantes")
@CrossOrigin( origins = "http://localhost:4200/")
public class RestauranteController implements GeneralControllerInterface<Restaurante>{
	
	@Autowired
	RestauranteService restauranteService;

	@Override
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/restaurantes", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<Response<List<Restaurante>>> obtenerTodos() throws RestauranteException {
		return ResponseEntity.ok(new Response<>(String.valueOf(HttpStatus.OK), restauranteService.obtenerTodos(), "Datos obtenidos correctamente"));
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/restaurantes/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<Response<Restaurante>> obtenerPorId(Integer id) throws RestauranteException {
		return ResponseEntity.ok(new Response<>(String.valueOf(HttpStatus.OK), restauranteService.obtenerPorId(id), "Datos obtenidos correctamente"));
	}


	@Override
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/crear", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<Response<Restaurante>> crear(Restaurante entity) throws RestauranteException {
		return ResponseEntity.ok(new Response<>(String.valueOf(HttpStatus.OK), restauranteService.crear(entity), "Creado correctamente"));
	}

	// revisar
	@Override
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
	public ResponseEntity<Response<Restaurante>> eliminar(Integer id) throws RestauranteException {
		return ResponseEntity.ok(new Response<>(String.valueOf(HttpStatus.OK), restauranteService.eliminarPorId(id), "Eliminado correctamente"));
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/actualizar/{id}", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	public ResponseEntity<Response<Restaurante>> actualizar(Restaurante entity, Integer id)
			throws RestauranteException {
		return ResponseEntity.ok(new Response<>(String.valueOf(HttpStatus.OK), restauranteService.actualizar(entity, id), "Actualizado correctamente"));
	}

	@Override
	public ResponseEntity<Response<Restaurante>> obtenerPorNombre(String nombre) throws RestauranteException {
		// TODO Auto-generated method stub
		return null;
	}

}
