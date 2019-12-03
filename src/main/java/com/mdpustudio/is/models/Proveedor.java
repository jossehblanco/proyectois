package com.mdpustudio.is.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PROVEEDOR", schema = "public")
public class Proveedor {
	
	@Id
	@GeneratedValue
	@Column(name = "idproveedor", nullable = false)
	private long idProveedor;
	
	@Column(name = "nombreproveedor", nullable = false)
	private String nombreProveedor;
	
	@Column(name = "descproveedor", nullable = false)
	private String descProveedor;
	
	@Column(name = "idemail", nullable = false)
	private long idEmail;

	
	//Setters & getters PROVEEDOR
	public long getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(long idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	public String getDescProveedor() {
		return descProveedor;
	}

	public void setDescProveedor(String descProveedor) {
		this.descProveedor = descProveedor;
	}

	public long getIdEmail() {
		return idEmail;
	}

	public void setIdEmail(long idEmail) {
		this.idEmail = idEmail;
	}

	public Proveedor(long idProveedor, String nombreProveedor, String descProveedor, long idEmail) {
		super();
		this.idProveedor = idProveedor;
		this.nombreProveedor = nombreProveedor;
		this.descProveedor = descProveedor;
		this.idEmail = idEmail;
	}

	public Proveedor() {
		
	}

}
