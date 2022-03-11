package com.restauranteScrum.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.restauranteScrum.entities.Persona;
import com.restauranteScrum.exceptions.RestauranteException;
import com.restauranteScrum.interfaces.GeneralControllerInterface;
import com.restauranteScrum.publics.Response;
import com.restauranteScrum.services.PersonaService;

@Controller
@RequestMapping(value = "/api/v1/personass")
public class PersonaController implements GeneralControllerInterface<Persona>{
	
	@Autowired
	PersonaService personaService;

	@Override
	public ResponseEntity<Response<List<Persona>>> obtenerTodos() throws RestauranteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Response<Persona>> obtenerPorId(Integer id) throws RestauranteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Response<Persona>> crear(Persona entity) throws RestauranteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/registrarPersonas", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<List<Persona>>> crearVarios(@RequestBody List<Persona> entities) throws RestauranteException {
		return ResponseEntity.ok(new Response<>(String.valueOf(HttpStatus.OK), this.personaService.crearVarios(entities), "Registros hechos"));
	}
	
	

	@Override
	public ResponseEntity<Response<Persona>> eliminar(Integer id) throws RestauranteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Response<Persona>> actualizar(Persona entity, Integer id) throws RestauranteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Response<Persona>> obtenerPorNombre(String nombre) throws RestauranteException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
