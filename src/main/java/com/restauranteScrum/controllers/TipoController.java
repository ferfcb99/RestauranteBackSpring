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

import com.restauranteScrum.entities.Tipo;
import com.restauranteScrum.exceptions.RestauranteException;
import com.restauranteScrum.interfaces.GeneralControllerInterface;
import com.restauranteScrum.publics.Response;
import com.restauranteScrum.services.TipoService;

@RestController
@RequestMapping(value = "/api/v1/tipos")
// http://localhost:8084/api/v1/tipos
@CrossOrigin( origins = "http://localhost:4200/" )
public class TipoController implements GeneralControllerInterface<Tipo>{
	
	@Autowired
	TipoService tipoService;

	
	
	// http://localhost:8084/api/v1/tipos/tipos
	@Override	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/tipos", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<Response<List<Tipo>>> obtenerTodos() throws RestauranteException {
		return ResponseEntity.ok(new Response<>(String.valueOf(HttpStatus.OK), tipoService.obtenerTodos(), "Datos obtenidos correctamente"));
	}
	

	// http://localhost:8084/api/v1/tipos/tipos/${id}
	@Override
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/tipos/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<Response<Tipo>> obtenerPorId(Integer id) throws RestauranteException {
		return ResponseEntity.ok(new Response<>(String.valueOf(HttpStatus.OK), tipoService.obtenerPorId(id), "Datos obtenidos correctamente"));
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/tipos/crear", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Tipo>> crear(Tipo entity) throws RestauranteException {
		return ResponseEntity.ok(new Response<>(String.valueOf(HttpStatus.OK), tipoService.crear(entity), "Creado correctamente"));
	}

	//http://localhost:8084/api/v1/tipos/eliminar/{id}
	@Override
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
	public ResponseEntity<Response<Tipo>> eliminar(Integer id) throws RestauranteException {
		return ResponseEntity.ok(new Response<>(String.valueOf(HttpStatus.OK), tipoService.eliminarPorId(id), "eliminado correctamente"));
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/actualizar/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	public ResponseEntity<Response<Tipo>> actualizar(Tipo entity, Integer id) throws RestauranteException {
		return ResponseEntity.ok(new Response<>(String.valueOf(HttpStatus.OK), tipoService.actualizar(entity, id), "Actualizado correctamente"));
	}
	
	
	@Override
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/tipo/nombre/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<Response<Tipo>> obtenerPorNombre(String nombre) throws RestauranteException {
		return ResponseEntity.ok(new Response<>(String.valueOf(HttpStatus.OK), tipoService.obtenerPorNombre(nombre), "datos obtenidos correctamente"));
	}
	
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/tipos/sql", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<Response<List<Tipo>>> obtenerSQL() throws RestauranteException {
		return ResponseEntity.ok(new Response<>(String.valueOf(HttpStatus.OK), tipoService.tipoConQueryNativo(), "Datos obtenidos correctamente"));
	}
	

}
