package com.mdpustudio.is.controller;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mdpustudio.is.models.Animal;
import com.mdpustudio.is.models.Sponsor;
import com.mdpustudio.is.models.Usuario;
import com.mdpustudio.is.repositories.AnimalRepository;
import com.mdpustudio.is.repositories.SponsorRepository;
import com.mdpustudio.is.repositories.UsuarioRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;



 
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
	
	@CrossOrigin
	@PostMapping("/auth/")
	public String login(@RequestParam String username, @RequestParam String pass) {
		System.out.println("Se recibio post");
		List<Usuario> users = usuarioRepository.findAll();
		Usuario user = null;
		boolean authed = false;
		for(int i = 0; i < users.size(); i++) {
			if(username.matches(users.get(i).getUsername()) && pass.matches(users.get(i).getPassword())) {
				user = users.get(i);
				authed = true;
				break;
			}
		}
		if(authed) {
			return this.getJWTToken(user.getUsername());
		}else return "not found";
	}
	
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
	
	
	
	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
	

	
}	