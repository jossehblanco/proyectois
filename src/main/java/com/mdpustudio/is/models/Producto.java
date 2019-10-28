package com.mdpustudio.is.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "PRODUCTO")
public class Producto {
	
	@Id
	@GeneratedValue
	@Column(name = "idproducto", nullable = false)
	private long idproducto;
	
	@Column(name = "nombreproducto", nullable = false)
	private String nombreProducto;
	
	@Column(name = "precio", nullable = false)
	private float precio;
	
	@Column(name = "descripcionproducto", nullable = false)
	private String descripcionproducto;
	
	@Column(name = "calificacion", nullable = false)
	private String calificacion;
	
	@Column(name = "url_imagen", nullable = false)
	private String url_imagen;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idproveedor", referencedColumnName = "idproveedor")
	@JsonIgnoreProperties("productos")
	private Proveedor proveedor;
	
	@OneToMany(mappedBy = "producto")
	@JsonIgnoreProperties("producto")
	private Set<ComentarioXProducto> comentario = new HashSet<>();

	public long getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(long idproducto) {
		this.idproducto = idproducto;
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

	public String getDescripcionproducto() {
		return descripcionproducto;
	}

	public void setDescripcionproducto(String descripcionproducto) {
		this.descripcionproducto = descripcionproducto;
	}

	public String getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}

	public String getUrl_imagen() {
		return url_imagen;
	}

	public void setUrl_imagen(String url_imagen) {
		this.url_imagen = url_imagen;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Set<ComentarioXProducto> getComentario() {
		return comentario;
	}

	public void setComentario(Set<ComentarioXProducto> comentario) {
		this.comentario = comentario;
	}
	
	

}
