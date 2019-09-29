package com.mdpustudio.is.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Producto {
	@Id
	@GeneratedValue
	@Column (name="idProducto", nullable =false)
	private long id;
	
	@Column(name="NombreProducto", nullable=false)
	private String nombreProducto;
	
	@Column(name="precio", nullable=false)
	private float precio;
	
	@Column(name="DescripcionProducto", nullable=false)
	private String DescripcionProducto;
	
	@Column(name="Calificacion", nullable=false)
	private int calificacion;
	
	@Column(name="IdProveedor", nullable=false)
	private long idProveedor;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getDescripcionProducto() {
		return DescripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		DescripcionProducto = descripcionProducto;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public long getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(long idProveedor) {
		this.idProveedor = idProveedor;
	}

	
	
}
