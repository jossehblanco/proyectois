package com.mdpustudio.is.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="ANIMAL")
public class Animal {
	//Con Id se define la PK
	//Con column se define una columna
	@Id
	@GeneratedValue 
	@Column(name = "idanimal", nullable = false)
	private long id;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@Column(name = "edad", nullable = false)
	private int edad;
	
	@Column(name = "peso", nullable = false)
	private int peso;
	
	@Column(name = "descripcion", nullable = false)
	private String descripcion;
	
	
	//@Column(name = "idespecie", nullable = false)
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idespecie", referencedColumnName = "idespecie")
	private Especie especie;
	

	//@Column(name = "idubicacion", nullable = false)
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idubicacion", referencedColumnName = "idubicacion")
	private Ubicacion ubicacion;
	
	@Column(name = "url_imagen", nullable = false)
	private String url_imagen;
	
	@OneToMany(mappedBy = "animal")
	@JsonIgnoreProperties({"animal", "animales"})
	private Set<Sponsor> sponsors = new HashSet<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Especie getEspecie() {
		return especie;
	}

	public void setEspecie(Especie especie) {
		this.especie = especie;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getUrl_imagen() {
		return url_imagen;
	}

	public void setUrl_imagen(String url_imagen) {
		this.url_imagen = url_imagen;
	}

	public Set<Sponsor> getSponsors() {
		return this.sponsors;
	}

	public void setSponsors(Set<Sponsor> sponsors) {
		this.sponsors = sponsors;
	}

	
	
}