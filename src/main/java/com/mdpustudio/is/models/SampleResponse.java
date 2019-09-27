package com.mdpustudio.is.models;

/*Esta es un clase modelo de PRUEBA.
* No está mapeada como entidad a ninguna base.
* Solo la hice para ver si funcionaba el json :vvvv
*
*/


public class SampleResponse {
	private String message;
	private long id;
	
	public String getMessage() {
		
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

}
