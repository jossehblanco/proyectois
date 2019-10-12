package com.mdpustudio.is.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mdpustudio.is.models.SponsorXAnimal;
import com.mdpustudio.is.models.SponsorXAnimalAux;

@Repository
public interface SponsorXAnimalRepository extends JpaRepository<SponsorXAnimal, Long>{ 
	
	@Query(value = "SELECT "
			+ "a.nombre AS nombre, s.nombresponsor AS sponsor, s.monto AS monto "		//en esta parte tenemos que poner por ejemplo AS nombre, entonces en la interfaz tocara poner getNombre
			+ "FROM ANIMAL a, SPONSOR s, SPONSORXANIMAL x "								//para AS sponsor toca poner getSponsor, y asi
			+ "WHERE a.idanimal = x.idanimal and s.idsponsor = x.idsponsor and a.idanimal = :idanimal ", nativeQuery = true) //para que funcione tiene que ser nativeQuery = true
	public List<SponsorXAnimalAux> findSponsorAnimal(@Param("idanimal") Long idanimal);	//le mandamos una List<*Nuestra interface*>
	
}
