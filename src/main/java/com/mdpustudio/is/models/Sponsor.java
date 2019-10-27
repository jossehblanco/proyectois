package com.mdpustudio.is.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="SPONSOR")
public class Sponsor {

	@Id
	@GeneratedValue
	@Column(name="idsponsor", nullable = false)
	private long id;
	
	@Column(name="monto", nullable = false)
	private float monto;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idanimal", referencedColumnName="idanimal")
	@JsonIgnoreProperties("sponsors")
	private Animal animal;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idusuario", referencedColumnName="idusuario")
	@JsonIgnoreProperties("sponsors")
	private Usuario usuario;
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}
	
}