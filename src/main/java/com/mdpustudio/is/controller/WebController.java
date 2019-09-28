package com.mdpustudio.is.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mdpustudio.is.models.Animal;
import com.mdpustudio.is.repositories.AnimalRepository;



 
/* Este anotador define un controlador Rest.
 * Es importante no usar @Controller porque tira un error de circle mapping y no devuelve el json.
 * Un controlador maneja varias respuestas HTTP.
 */

@RestController
public class WebController {
	//Con Request mapping, mapeamos codigo java a una url determinado. Por ejemplo
	//Si accedemos a localhost:8080/sample se va a ejecutar el siguiente código.
	/*
	@RequestMapping("/sample")
	public SampleResponse Sample(@RequestParam(value = "name", defaultValue = "Robot") String name) {
		SampleResponse response = new SampleResponse();
		response.setId(1);
		response.setMessage("Hola, tu nombre es:  " +name);
		return response;
	}
	*/
	
	//Autowired se encarga de hacer inyección de dependencias automaticamente sin necesidad de reaizar 
	//configuración extra. 
	
	@Autowired
	private AnimalRepository animalRepository;
	
	//Utilizamos GET para obtener una lista de los animales en localhost:8080/animales
	@GetMapping("/animales")
	public List<Animal>  getAllAnimales(){
		return animalRepository.findAll();
	}
	
	
	//Aquí se utiliza @PathVariable para definir una variable que se mandará en el GET. Se utiliza antes de declarar Long animalId
	//Para mapear el id a la variable.
	
	//FindById retorna un tipo Optional<Animal> porque puede ser nulo o levantar alguna excepción.
	//Se utilizó findByID(id).orElse(null) para retornar un nulo en caso de que el id del animal no se encuentre.
	
	@GetMapping("/animales/{id}")
	public ResponseEntity<Animal> getAnimalById( @PathVariable(value = "id") Long animalId){
		Animal animal = animalRepository.findById(animalId).orElse(null);
		return ResponseEntity.ok().body(animal);
	}
}
