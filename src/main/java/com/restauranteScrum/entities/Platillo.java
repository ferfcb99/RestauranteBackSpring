package com.restauranteScrum.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "platillo")
public class Platillo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private Integer id;
	
	@Column(name = "nombre", length = 100, unique = true, nullable = false)
	private String nombre;
	
	
	@Column(name = "tamano", length = 100)
	private String tamano;
	
	@Column(name = "precio", nullable = false, precision = 3, scale = 2)
	// @Digits(integer = 3, fraction = 2)
	private Double precio;
	
	//@JsonIgnore // FetchType.LAZY, EAGER
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "restaurante_id", nullable = false)
	private Restaurante restaurante;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	// @JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo_id", nullable = false)
	private Tipo tipo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTamano() {
		return tamano;
	}

	public void setTamano(String tamano) {
		this.tamano = tamano;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	
	
}
