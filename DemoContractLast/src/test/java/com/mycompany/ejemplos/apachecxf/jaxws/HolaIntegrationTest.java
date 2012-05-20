package com.mycompany.ejemplos.apachecxf.jaxws;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ContextConfiguration("/applicationContext-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class HolaIntegrationTest {

	
	
	/**
	 * Interface del Web Service a probar. La implementaci—n es el proxy de
	 * Apache CXF que se inyecta mediante Spring. La configuraci—n se encuentra
	 * en el applicationContext-test.xml
	 */
	@Autowired
	private Hola hola;

	/**
	 * Test de integraci—n, este test prueba el Web Service desplegado.
	 */
	@Test
	public void testSaludar() {
		Assert.assertEquals("Hola Pepe", hola.saludar("Pepe"));
	}
}
