package com.mdpustudio.is.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mdpustudio.is.models.SampleResponse;



@RestController 
/* Este anotador define un controlador Rest.
 * Es importante no usar @Controller porque tira un error de circle mapping y no devuelve el json.
 * Un controlador maneja varias respuestas HTTP.
 */
public class WebController {
	//Con Request mapping, mapeamos codigo java a una url determinado. Por ejemplo
	//Si accedemos a localhost:8080/sample se va a ejecutar el siguiente código.
	
	@RequestMapping("/sample")
	public SampleResponse Sample(@RequestParam(value = "name", defaultValue = "Robot") String name) {
		SampleResponse response = new SampleResponse();
		response.setId(1);
		response.setMessage("Hola, tu nombre es:  " +name);
		return response;
	}
	

}
