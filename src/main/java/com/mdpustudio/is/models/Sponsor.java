package com.mdpustudio.is.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="SPONSOR")
public class Sponsor {

	@Id
	@GeneratedValue
	@Column(name="idsponsor", nullable = false)
	private long idsponsor;
	
	@Column(name="nombresponsor", nullable = false)
	private String nombresponsor;
	
	@Column(name="monto", nullable = false)
	private float monto;
	
	/*@OneToMany(mappedBy = "SPONSOR", fetch = FetchType.LAZY)
	private List<SponsorXAnimal> sponsorxanimal;
*/
	
	//Setters & Gettters SPONSOR
	public long getIdsponsor() {
		return idsponsor;
	}

	public void setIdsponsor(long idsponsor) {
		this.idsponsor = idsponsor;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public String getNombresponsor() {
		return nombresponsor;
	}

	public void setNombresponsor(String nombresponsor) {
		this.nombresponsor = nombresponsor;
	}

	public Sponsor(long idsponsor, String nombresponsor, float monto) {
		super();
		this.idsponsor = idsponsor;
		this.nombresponsor = nombresponsor;
		this.monto = monto;
	}

	
	public Sponsor() {
		
	}
	/*public List<SponsorXAnimal> getSponsorxanimal() {
		return sponsorxanimal;
	}

	public void setSponsorxanimal(List<SponsorXAnimal> sponsorxanimal) {
		this.sponsorxanimal = sponsorxanimal;
	}*/
	
	
	
}
