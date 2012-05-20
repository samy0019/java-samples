package com.mycompany.ejemplos.apachecxf.jaxws;

import javax.jws.WebService;


/**
 * Implementaci—n del Web Service, el endpointInterface es el fully qualified
 * name de la interface que implementa.
 * 
 * @author joedayz
 */




@WebService(endpointInterface = "com.mycompany.ejemplos.apachecxf.jaxws.Hola")
public class HolaImpl implements Hola {

	public String saludar(String nombre) {
		return "Hola " + nombre;
	}

}
