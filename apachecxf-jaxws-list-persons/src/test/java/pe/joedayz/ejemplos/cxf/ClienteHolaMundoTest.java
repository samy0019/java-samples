package pe.joedayz.ejemplos.cxf;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *  En este test crearemos un cliente del Web Service utilizando Apache CXF.
 *  El cliente se crea dinámicamente a través de Spring. En el archivo de
 *  configuración de Spring applicationContext.xml de este test se declara
 *  el cliente, el cual cumplirá con la interfaz del Web Service. 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:pe/joedayz/ejemplos/cxf/applicationTest.xml"})
public class ClienteHolaMundoTest {

    @Autowired
    private HolaMundo instance = new HolaMundoImpl();

    /**
     * Test of decirHola method, of class HolaMundo.
     */
    
    @Test
    public void testDecirHola() {
        System.out.println("decirHola");
        String nombre = "Zim";
        String expResult = "Hola, " + nombre;

        String result = instance.decirHola(nombre);

        assertEquals(expResult, result);
    }

    /**
     * Test of buscarPersona method, of class HolaMundo.
     */
    @Test
    public void testBuscarPersona() {
        System.out.println("buscarPersona");
        long legajo = 29L;

        Persona result = instance.buscarPersona(legajo);

        assertNotNull(result);
        assertEquals(legajo, result.getLegajo());
        assertNotNull(result.getNombre());
        assertTrue(!result.getNombre().isEmpty());
    }

}