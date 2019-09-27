package com.mdpustudio.is;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*Esta clase practicamente inicializa la aplicación, es una combinación
 * de los decorators que ocupabamos en ncapas:
 * @Configuration
 * @EnableAutoConfiguration
 * @ComponentScan
 * 
 * Pero ahora al parecer se ocupa solo @SpringBootApplication
 * Gran hack


*/
@SpringBootApplication
public class ProyectoIsApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(ProyectoIsApplication.class, args);
	}

}
