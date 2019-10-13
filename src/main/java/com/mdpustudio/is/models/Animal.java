package com.mdpustudio.is.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.util.ResourceUtils;

@Entity
@Table(name="ANIMAL")
public class Animal {
	//Con Id se define la PK
	//Con column se define una columna
	@Id
	@GeneratedValue 
	@Column(name = "idanimal", nullable = false)
	private long idanimal;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@Column(name = "edad", nullable = false)
	private int edad;
	
	@Column(name = "peso", nullable = false)
	private int peso;
	
	@Column(name = "tiposangre", nullable = false)
	private String tipoSangre;
	
	@Column(name = "descripcion", nullable = false)
	private String descripcion;
	
	@Column(name = "idespecie", nullable = false)
	private long idespecie;
	
	@Column(name = "idubicacion", nullable = false)
	private long idubicacion;
	
	
	@Column(name = "url_imagen", nullable = false)
	private String url_imagen;
	
	//@OneToMany(mappedBy = "Animal", fetch = FetchType.LAZY)
	//private List<SponsorXAnimal> sponsorxanimal;


	//Getters y setters para el modelo Animal
	
	
	
	public long getId() {
		return idanimal;
	}

	public String getUrl_imagen() {
		return url_imagen;
	}

	public void setUrl_imagen(String url_imagen) {
		this.url_imagen = url_imagen;
	}

	public void setId(long id) {
		this.idanimal = id;
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

	public String getTipoSangre() {
		return tipoSangre;
	}

	public void setTipoSangre(String tipoSangre) {
		this.tipoSangre = tipoSangre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public long getIdespecie() {
		return idespecie;
	}

	public void setIdespecie(long idespecie) {
		this.idespecie = idespecie;
	}

	public long getIdubicacion() {
		return idubicacion;
	}

	public void setIdubicacion(long idubicacion) {
		this.idubicacion = idubicacion;
	}

	/*public List<SponsorXAnimal> getSponsorxanimal() {
		return sponsorxanimal;
	}

	public void setSponsorxanimal(List<SponsorXAnimal> sponsorxanimal) {
		this.sponsorxanimal = sponsorxanimal;
	}*/
	
	
	
	
	
}