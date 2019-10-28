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
@Table(name="USUARIO")
public class Usuario {
	@Id
	@GeneratedValue 
	@Column(name= "idusuario")
	private long id;
	
	@Column(name= "username")
	private String username;
	
	@Column(name= "password")
	private String password;
	
	@Column(name= "email")
	private String email;
	
	@Column(name= "active")
	private boolean active;
	
	@OneToMany(mappedBy = "usuario")	
	@JsonIgnoreProperties({"usuario", "sponsors"})
	private Set<Sponsor> sponsors = new HashSet<>();

	public Set<Sponsor> getSponsors() {
		return sponsors;
	}

	public void setSponsors(Set<Sponsor> sponsors) {
		this.sponsors = sponsors;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Usuario(String username, String password, String email, boolean active) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.active = active;
	}
	
	public Usuario() {
		
	}
	
	
	
	
}
