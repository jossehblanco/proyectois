package com.mdpustudio.is.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mdpustudio.is.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO USUARIO(username, password, email, active) VALUES (:username, :password, :email, :status)", nativeQuery = true)
	void insertUser(@Param("username") String username, @Param("password") String password, @Param("email") String email, @Param("status") boolean status);
	
}
