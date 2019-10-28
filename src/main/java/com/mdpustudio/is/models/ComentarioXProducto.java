package com.mdpustudio.is.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "COMENTARIOXPRODUCTO")
public class ComentarioXProducto {

	@Id
	@GeneratedValue
	@Column(name = "idcomentario", nullable = false)
	private long idcomentario;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idproducto", referencedColumnName = "idproducto")
	@JsonIgnoreProperties("comentario")
	private Producto producto;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
	@JsonIgnoreProperties("sponsors")
	private Usuario usuario;
	
	@Column(name = "descripcioncomentario", nullable = false)
	private String descripcioncomentario;

	public long getIdcomentario() {
		return idcomentario;
	}

	public void setIdcomentario(long idcomentario) {
		this.idcomentario = idcomentario;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDescripcioncomentario() {
		return descripcioncomentario;
	}

	public void setDescripcioncomentario(String descripcioncomentario) {
		this.descripcioncomentario = descripcioncomentario;
	}
	
	
	
}
