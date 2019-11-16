package com.mdpustudio.is.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UBICACION")
public class Ubicacion {

	@Id
	@GeneratedValue
	@Column(name = "idubicacion", nullable = false)
	private long id;
	
	@Column(name = "nombreubicacion", nullable = false)
	private String nombre;

	//Setters & Getters UBICACION	
	public long getId() {
		return this.id;
	}

	public void setId(long idUbicacion) {
		this.id = idUbicacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombreUbicacion) {
		this.nombre = nombreUbicacion;
	}
	
	
	
}
