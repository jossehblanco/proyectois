package com.mdpustudio.is.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mdpustudio.is.models.Animal;



/*Con @Repository se marca un repositorio (el cual debe ser utilizado con Autowired cuando se requiera. 
 * (Mirar el ejemplo en el controlador)
 * Cada repositorio debe ser codificado como una interfaz que exctiende de JpaRepository o algun tipo de repositorio.
 * AL hacer esto, se obtiene acceso a todos los metodos de JpaRepository (findAll(), findById(). save()... )
*/

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long>{
	//Aqui no va nada, al menos que se desee hacer override a algun metodo para algun fin.
}
