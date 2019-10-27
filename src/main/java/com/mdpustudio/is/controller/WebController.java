package com.mdpustudio.is.controller;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mdpustudio.is.models.Animal;
import com.mdpustudio.is.models.Sponsor;
import com.mdpustudio.is.repositories.AnimalRepository;

import com.mdpustudio.is.repositories.SponsorRepository;



 
/* Este anotador define un controlador Rest.
 * Es importante no usar @Controller porque tira un error de circle mapping y no devuelve el json.
 * Un controlador maneja varias respuestas HTTP.
 */

@RestController
public class WebController {
	//Con Request mapping, mapeamos codigo java a una url determinado. Por ejemplo
	//Si accedemos a localhost:8080/sample se va a ejecutar el siguiente código.
	
	//Autowired se encarga de hacer inyección de dependencias automaticamente sin necesidad de reaizar 
	//configuración extra. 
	
	@Autowired
	private AnimalRepository animalRepository;
	@Autowired
	private SponsorRepository sponsorRepository;

	//Utilizamos GET para obtener una lista de los animales en localhost:8080/animales
	@CrossOrigin
	@GetMapping("/animales")
	public List<Animal>  getAllAnimales(){
		return animalRepository.findAll();
	}
	

	
	
	@CrossOrigin
	@GetMapping("/sp")
	public List<Sponsor>  getAllSponsors(){
		return  sponsorRepository.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/animales/{id}")
	public ResponseEntity<Animal> getAnimalById( @PathVariable(value = "id") Long animalId){
		Animal animal = animalRepository.findById(animalId).orElse(null);
		return ResponseEntity.ok().body(animal);
	}
	
}