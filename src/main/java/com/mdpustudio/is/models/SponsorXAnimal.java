package com.mdpustudio.is.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="SPONSORXANIMAL")
public class SponsorXAnimal {
	
	@Id
	@GeneratedValue
	@Column(name = "idsponsorxanimal", nullable = false)
	private long idsponsorxanimal;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idanimal")
	private Animal animal;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idsponsor")
	private Sponsor sponsor;

	//Setters & Getters SPONSORXANIMAL
	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Sponsor getSponsor() {
		return sponsor;
	}

	public void setSponsor(Sponsor sponsor) {
		this.sponsor = sponsor;
	}

	

}
