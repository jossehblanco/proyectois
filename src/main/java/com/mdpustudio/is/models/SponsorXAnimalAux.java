package com.mdpustudio.is.models;

//interface que se utiliza para poder obtener la respuesta de nuestro @Query 
public interface SponsorXAnimalAux {
	
	String getNombre();			//en @Query: AS nombre
	String getSponsor();		//en @Query: AS sponsor
	Long getMonto();			//en @Query: AS monto

}

