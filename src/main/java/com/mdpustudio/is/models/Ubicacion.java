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
	private long idUbicacion;
	
	@Column(name = "nombreubicacion", nullable = false)
	private String nombreUbicacion;

	//Setters & Getters UBICACION	
	public long getIdUbicacion() {
		return idUbicacion;
	}

	public void setIdUbicacion(long idUbicacion) {
		this.idUbicacion = idUbicacion;
	}

	public String getNombreUbicacion() {
		return nombreUbicacion;
	}

	public void setNombreUbicacion(String nombreUbicacion) {
		this.nombreUbicacion = nombreUbicacion;
	}
	
	
	
}
