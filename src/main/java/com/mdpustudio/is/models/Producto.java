package com.mdpustudio.is.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCTO")
public class Producto {
	@Id
	@GeneratedValue
	@Column (name="idproducto", nullable =false)
	private long id;
	
	@Column(name="nombreproducto", nullable=false)
	private String nombreProducto;
	
	@Column(name="precio", nullable=false)
	private float precio;
	
	@Column(name="descripcionproducto", nullable=false)
	private String DescripcionProducto;
	
	@Column(name="calificacion", nullable=false)
	private int calificacion;
	
	@Column(name="idproveedor", nullable=false)
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

	public Producto(long id, String nombreProducto, float precio, String descripcionProducto, int calificacion,
			long idProveedor) {
		super();
		this.id = id;
		this.nombreProducto = nombreProducto;
		this.precio = precio;
		DescripcionProducto = descripcionProducto;
		this.calificacion = calificacion;
		this.idProveedor = idProveedor;
	}
	
	public Producto() {
		
	}

	
	
}
