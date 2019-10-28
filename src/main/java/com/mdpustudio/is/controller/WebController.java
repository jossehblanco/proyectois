package com.mdpustudio.is.controller;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mdpustudio.is.models.Animal;
import com.mdpustudio.is.models.Producto;
import com.mdpustudio.is.models.Proveedor;
import com.mdpustudio.is.models.Sponsor;
import com.mdpustudio.is.models.Usuario;
import com.mdpustudio.is.repositories.AnimalRepository;
import com.mdpustudio.is.repositories.ProductoRepository;
import com.mdpustudio.is.repositories.ProveedorRepository;
import com.mdpustudio.is.repositories.SponsorRepository;
import com.mdpustudio.is.repositories.UsuarioRepository;



 
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
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private ProveedorRepository proveedorRepository;
	@Autowired
	private ProductoRepository productoRepository;

	//Utilizamos GET para obtener una lista de los animales en localhost:8080/animales
	@CrossOrigin
	@GetMapping("/animales")
	public List<Animal>  getAllAnimales(){
		return animalRepository.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/animales/{id}")
	public ResponseEntity<Animal> getAnimalById( @PathVariable(value = "id") Long animalId){
		Animal animal = animalRepository.findById(animalId).orElse(null);
		return ResponseEntity.ok().body(animal);
	}
	
	
	@CrossOrigin
	@GetMapping("/proveedor")
	public List<Proveedor> getAllProveedores(){
		return proveedorRepository.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/proveedor/{id}")
	public ResponseEntity<Proveedor> getProveedorById( @PathVariable(value = "id") Long proveedorID){
		Proveedor proveedor = proveedorRepository.findById(proveedorID).orElse(null);
		return ResponseEntity.ok().body(proveedor);
	}
	
	
	@CrossOrigin
	@GetMapping("/productos")
	public List<Producto> getAllProductos(){
		return productoRepository.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/productos/{id}")
	public ResponseEntity<Producto> getProductoById( @PathVariable(value = "id") Long productoID){
		Producto producto = productoRepository.findById(productoID).orElse(null);
		return ResponseEntity.ok().body(producto);
	}
	
	@CrossOrigin
	@GetMapping("/sp")
	public List<Sponsor>  getAllSponsors(){
		return  sponsorRepository.findAll();
	}
	

	@CrossOrigin
	@RequestMapping(value = "/registro", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Usuario> insertUsuario(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("email") String email) {
		Usuario newUsuario = new Usuario(username, password, email, true);
		
		usuarioRepository.insertUser(newUsuario.getUsername(), newUsuario.getPassword(), newUsuario.getEmail(), newUsuario.isActive());
		
		return ResponseEntity.ok().body(newUsuario);
	}
	
}