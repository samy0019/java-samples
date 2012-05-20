package com.mycompany.ejemplos.apachecxf.jaxws;

import javax.jws.WebService;

/**
 * Copia de la interface del Web Service.
 * 
 * @author joedayz
 *
 */
@WebService
public interface Hola {

	public String saludar(String nombre);

}