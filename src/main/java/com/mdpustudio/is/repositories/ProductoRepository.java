package com.mdpustudio.is.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mdpustudio.is.models.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {

}
