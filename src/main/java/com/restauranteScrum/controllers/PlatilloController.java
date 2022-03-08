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

import com.restauranteScrum.entities.Platillo;
import com.restauranteScrum.exceptions.RestauranteException;
import com.restauranteScrum.interfaces.GeneralControllerInterface;
import com.restauranteScrum.publics.Response;
import com.restauranteScrum.services.PlatilloService;

@RestController
@RequestMapping(value = "/api/v1/platillos")
@CrossOrigin( origins = "http://localhost:4200/" )

public class PlatilloController implements GeneralControllerInterface<Platillo>{
	
	@Autowired
	PlatilloService platilloService;

	@Override
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/platillos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<List<Platillo>>> obtenerTodos() throws RestauranteException {
		return ResponseEntity.ok(new Response<>(String.valueOf(HttpStatus.OK), platilloService.obtenerTodos(), "Datos obtenidos correctamente"));
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/platillos/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Platillo>> obtenerPorId(Integer id) throws RestauranteException {
		return ResponseEntity.ok(new Response<>(String.valueOf(HttpStatus.OK), platilloService.obtenerPorId(id), "Datos obtenidos correctamente"));
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/crear", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Platillo>> crear(Platillo entity) throws RestauranteException {
		return ResponseEntity.ok(new Response<>(String.valueOf(HttpStatus.OK), platilloService.crear(entity), "Creado correctamente"));
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Platillo>> eliminar(Integer id) throws RestauranteException {
		return ResponseEntity.ok(new Response<>(String.valueOf(HttpStatus.OK), platilloService.eliminarPorId(id), "Datos eliminados correctamente"));
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/actualizar/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Platillo>> actualizar(Platillo entity, Integer id) throws RestauranteException {
		return ResponseEntity.ok(new Response<>(String.valueOf(HttpStatus.OK), platilloService.actualizar(entity, id), "Datos eliminados correctamente"));
	}

	@Override
	public ResponseEntity<Response<Platillo>> obtenerPorNombre(String nombre) throws RestauranteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/platillos/restaurante/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<List<Platillo>>> obtenerPlatillosPorIdRestaurante(Integer id) throws RestauranteException {
		return ResponseEntity.ok(new Response<>(String.valueOf(HttpStatus.OK), platilloService.obtenerPlatillosPorIdRestaurante(id), "Datos obtenidos correctamente"));
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/platillos/tipo/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<List<Platillo>>> obtenerPorTipoId(Integer id) throws RestauranteException {
		return ResponseEntity.ok(new Response<>(String.valueOf(HttpStatus.OK), platilloService.obtenerPlatillosPorIdTipo(id), "Datos obtenidos correctamente"));
	}


}
