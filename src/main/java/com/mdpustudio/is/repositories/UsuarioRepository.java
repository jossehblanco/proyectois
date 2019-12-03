package com.mdpustudio.is.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mdpustudio.is.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
	
	
}