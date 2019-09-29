package com.mdpustudio.is.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mdpustudio.is.models.Sponsor;

@Repository
public interface SponsorRepository extends JpaRepository<Sponsor, Long>{

}
