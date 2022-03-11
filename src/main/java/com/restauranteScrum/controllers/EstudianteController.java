package com.restauranteScrum.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.restauranteScrum.entities.Estudiante;
import com.restauranteScrum.exceptions.RestauranteException;
import com.restauranteScrum.services.EstudianteService;

import java.util.List;
import com.restauranteScrum.publics.Response;

@RestController
@RequestMapping(value = "/api/v1/restudiante")
public class EstudianteController {

	@Autowired
	EstudianteService estudianteService;
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/obtenerTodos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<List<Estudiante>>> obtenerTodos() throws RestauranteException{
		return ResponseEntity.ok(new Response<>(String.valueOf(HttpStatus.OK), estudianteService.obtenerTodos(), "Datos obtenidos correctamente")); // 200, 404, 400, 500 
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/crearVarios", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<List<Estudiante>>> creraVarios(@RequestBody List<Estudiante> estudiantes) throws RestauranteException{
		return ResponseEntity.ok(new Response<>(String.valueOf(HttpStatus.OK), estudianteService.crearVarios(estudiantes), "Datos obtenidos correctamente")); // 200, 404, 400, 500 
	}
	
}
