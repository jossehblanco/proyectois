package com.mdpustudio.is;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.mdpustudio.is.security.JWTAuthorizationFilter;


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
	
	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.cors().and().csrf().disable()
				.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/auth/").permitAll()
				.antMatchers(HttpMethod.POST, "/nusr/").permitAll()
				.anyRequest().authenticated();
		}
	}

}
