package com.mdpustudio.is;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mdpustudio.is.controller.WebController;
import com.mdpustudio.is.models.Animal;
import com.mdpustudio.is.models.Producto;
import com.mdpustudio.is.models.Usuario;
import com.mdpustudio.is.repositories.AnimalRepository;
import com.mdpustudio.is.repositories.ProductoRepository;
import com.mdpustudio.is.repositories.ProveedorRepository;
import com.mdpustudio.is.repositories.SponsorXAnimalRepository;
import com.mdpustudio.is.repositories.UsuarioRepository;


@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class ProyectoIsApplicationTests{
	
	//Inyectando mock dependencies
	@InjectMocks
	WebController webController;
	
	
	@Mock
	private AnimalRepository animalRepository;
	
	
	@Mock
	private ProveedorRepository proveedorRepository;

	
	@Mock
	private ProductoRepository productoRepository;
	
	@Mock
	private SponsorXAnimalRepository sponsorxanimalRepository;
	
	@Mock
	private UsuarioRepository usuarioRepository;
	
	
	//Tests para los endpoints que devuelven las listas
	
	@Test
	public void testFindAnimales() {
		Animal a1 = new Animal(23, "prueba1", 123, 123, "rpueba", "desc", 1, 2, "asd");
		Animal a2 = new Animal(23, "prueba1", 123, 123, "rpueba", "desc", 1, 2, "asd");
		List <Animal> animales = new ArrayList<Animal>();
		
		animales.add(a1);
		animales.add(a2);
		
		when(animalRepository.findAll()).thenReturn(animales);
		
		List<Animal> resultado = webController.getAllAnimales();
		
		assertThat(resultado.size()).isEqualTo(2);
		assertThat(resultado.size()).isEqualTo(2);
		assertThat(resultado.get(0).getNombre()).isEqualTo(a1.getNombre());
		assertThat(resultado.get(1).getNombre()).isEqualTo(a2.getNombre());
		
	}
	
	@Test
	public void testFindProductos() {
		Producto p1 = new Producto(123, "prueba", 23.4f, "prueba", 5, 2);
		Producto p2 = new Producto(124, "prueba2", 23.4f, "prueba3", 5, 2);
		List <Producto> productos = new ArrayList<Producto>();
		
		productos.add(p1);
		productos.add(p2);
		
		when(productoRepository.findAll()).thenReturn(productos);
		
		List<Producto> resultado = webController.getAllProductos();
		
		assertThat(resultado.size()).isEqualTo(2);
		assertThat(resultado.size()).isEqualTo(2);
		assertThat(resultado.get(0).getNombreProducto()).isEqualTo(p1.getNombreProducto());
		assertThat(resultado.get(1).getNombreProducto()).isEqualTo(p2.getNombreProducto());
	}
	
	@Test
	public void testFindUsuarios() {
		Usuario u1 = new Usuario(1, "prueba", "pwd");
		Usuario u2 = new Usuario(1, "prueba2", "pwd2");
		List <Usuario> usuarios = new ArrayList<Usuario>();
		
		usuarios.add(u1);
		usuarios.add(u2);
		
		when(usuarioRepository.findAll()).thenReturn(usuarios);
		
		List<Usuario> resultado = webController.getAllUsers();
		
		assertThat(resultado.size()).isEqualTo(2);
		assertThat(resultado.size()).isEqualTo(2);
		assertThat(resultado.get(0).getUsername()).isEqualTo(u1.getUsername());
		assertThat(resultado.get(1).getUsername()).isEqualTo(u2.getUsername());
	}
	
	
	@Test
	public void testAnimalConstructor() {
		Animal a1 = null;
		a1 = new Animal(23l, "prueba1", 123, 123, "rprueba", "desc", 1, 2, "asd");
		assertThat(a1.getId()).isEqualTo(23l);
		assertThat(a1.getEdad()).isEqualTo(123);
		assertThat(a1.getPeso()).isEqualTo(123);
		assertThat(a1.getTipoSangre()).isEqualTo("rprueba");
		assertThat(a1.getDescripcion()).isEqualTo("desc");
		assertThat(a1.getIdespecie()).isEqualTo(1);
		assertThat(a1.getIdubicacion()).isEqualTo(2);
		assertThat(a1.getUrl_imagen()).isEqualTo("asd");
	}
	
	
	@Test
	public void testUsuarioConstructor() {
		Usuario u1 = null;
		u1 = new Usuario(23, "username", "pwd");
		assertThat(u1).isNotNull();
	}
	
	
	@Test
	public void testProductoConstructor() {
		Producto p1 = null;
		p1 = new Producto(123, "prueba", 23.4f, "prueba", 5, 2);
		assertThat(p1).isNotNull();
	}
	
	
	
	

	
}
/*



import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProyectoIsApplicationTests {

	@Test
	public void contextLoads() {
		
	}

}
*/