package com.mdpustudio.is.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "PROVEEDOR")
public class Proveedor {
	
	@Id
	@GeneratedValue
	@Column(name = "idproveedor", nullable = false)
	private long idproveedor;
	
	@Column(name = "nombreproveedor", nullable = false)
	private String nombreproveedor;
	
	@Column(name = "descproveedor", nullable = false)
	private String descproveedor;
	
	@Column(name = "idemail", nullable = false)
	private long idemail;
	
	@OneToMany(mappedBy = "proveedor")
	@JsonIgnoreProperties({"proveedor"})
	private Set<Producto> productos = new HashSet<>();

	public long getIdproveedor() {
		return idproveedor;
	}

	public void setIdproveedor(long idproveedor) {
		this.idproveedor = idproveedor;
	}

	public String getNombreproveedor() {
		return nombreproveedor;
	}

	public void setNombreproveedor(String nombreproveedor) {
		this.nombreproveedor = nombreproveedor;
	}

	public String getDescproveedor() {
		return descproveedor;
	}

	public void setDescproveedor(String descproveedor) {
		this.descproveedor = descproveedor;
	}

	public long getIdemail() {
		return idemail;
	}

	public void setIdemail(long idemail) {
		this.idemail = idemail;
	}

	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}
	
		
	

}
