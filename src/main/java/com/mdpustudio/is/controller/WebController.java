package com.mdpustudio.is.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mdpustudio.is.models.Animal;
import com.mdpustudio.is.models.Producto;
import com.mdpustudio.is.models.Proveedor;
import com.mdpustudio.is.models.SponsorXAnimal;
import com.mdpustudio.is.models.SponsorXAnimalAux;
import com.mdpustudio.is.repositories.AnimalRepository;
import com.mdpustudio.is.repositories.ProductoRepository;
import com.mdpustudio.is.repositories.ProveedorRepository;
import com.mdpustudio.is.repositories.SponsorXAnimalRepository;



 
/* Este anotador define un controlador Rest.
 * Es importante no usar @Controller porque tira un error de circle mapping y no devuelve el json.
 * Un controlador maneja varias respuestas HTTP.
 */

@RestController
public class WebController {
	//Con Request mapping, mapeamos codigo java a una url determinado. Por ejemplo
	//Si accedemos a localhost:8080/sample se va a ejecutar el siguiente código.
	/*
	@CrossOrigin
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
	
	@Autowired
	private ProveedorRepository proveedorRepository;

	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private SponsorXAnimalRepository sponsorxanimalRepository;

	//Utilizamos GET para obtener una lista de los animales en localhost:8080/animales
	@CrossOrigin
	@GetMapping("/animales")
	public List<Animal>  getAllAnimales(){
		return animalRepository.findAll();
	}
	@CrossOrigin
	@GetMapping("/productos")
	public List<Producto> getAllProductos(){
		return productoRepository.findAll();
	}
	
	
	//Aquí se utiliza @PathVariable para definir una variable que se mandará en el GET. Se utiliza antes de declarar Long animalId
	//Para mapear el id a la variable.
	
	//FindById retorna un tipo Optional<Animal> porque puede ser nulo o levantar alguna excepción.
	//Se utilizó findByID(id).orElse(null) para retornar un nulo en caso de que el id del animal no se encuentre.
	
	@CrossOrigin
	@GetMapping("/animales/{id}")
	public ResponseEntity<Animal> getAnimalById( @PathVariable(value = "id") Long animalId){
		Animal animal = animalRepository.findById(animalId).orElse(null);
		return ResponseEntity.ok().body(animal);
	}
	@CrossOrigin
	@GetMapping("/productos/{id}")
	public ResponseEntity<Producto> getProductById(@PathVariable(value="id") Long productoId){
		Producto producto = productoRepository.findById(productoId).orElse(null);
		return ResponseEntity.ok().body(producto);
	}

	//AlexanderRivz
	@CrossOrigin
	@GetMapping("/proveedor/{id}")
	public ResponseEntity<Proveedor> getProveedorById( @PathVariable(value = "id") Long proveedorId){
		Proveedor proveedor = proveedorRepository.findById(proveedorId).orElse(null);
		return ResponseEntity.ok().body(proveedor);
	}
	
	@CrossOrigin
	@GetMapping("/proveedor")
	public List<Proveedor> getAllProveedores(){
		return proveedorRepository.findAll();
	}
	
	
	@CrossOrigin
	@GetMapping("/sponsor/{idanimal}")
	public ResponseEntity<List<SponsorXAnimalAux>> getSponsor(@PathVariable(value = "idanimal") Long idanimal){	//En esta mandamos un ResponseEntity<List<*Nuestra interface*>> 
		List<SponsorXAnimalAux> sponsorxanimal = sponsorxanimalRepository.findSponsorAnimal(idanimal);
		return ResponseEntity.ok().body(sponsorxanimal);
	}	
	
}