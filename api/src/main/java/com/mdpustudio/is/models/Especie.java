package com.mdpustudio.is.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ESPECIE")
public class Especie {
	
	@Id
	@GeneratedValue
	@Column(name = "idespecie", nullable = false)
	private long id;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;

	//Setters & Getters UBICACION	
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

}
