package com.mdpustudio.is.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mdpustudio.is.models.SponsorXAnimal;

@Repository
public interface SponsorXAnimalRepository extends JpaRepository<SponsorXAnimal, Long>{
	
	@Query(value = "select a.nombre, s.nombresponsor , s.monto from ANIMAL a, SPONSOR s, SPONSORXANIMAL x "
			+ "where a.idanimal = x.idanimal and s.idsponsor = x.idsponsor and a.idanimal = :idanimal ", nativeQuery = true)
	public List<Object[]> findSponsorAnimal(@Param("idanimal") Long idanimal);
	
}
