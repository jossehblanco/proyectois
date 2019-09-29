package com.mdpustudio.is.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMAIL")
public class Email {
	
	@Id
	@GeneratedValue
	@Column(name = "idemail", nullable = false)
	private long idEmail;
	
	@Column(name = "email", nullable = false)
	private String email;

	
	//Setters & Getters EMAIL
	public long getIdEmail() {
		return idEmail;
	}

	public void setIdEmail(long idEmail) {
		this.idEmail = idEmail;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
