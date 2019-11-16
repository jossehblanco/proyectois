package com.mdpustudio.is.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mdpustudio.is.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
