package pe.joedayz.ejemplos.cxf;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;


@WebService(endpointInterface = "pe.joedayz.ejemplos.cxf.HolaMundo")
public class HolaMundoImpl implements HolaMundo {

	
    public String decirHola(String nombre) {
        return "Hola, " + nombre;
    }

    public Persona buscarPersona(long legajo) {
        Persona persona = new Persona();
        persona.setLegajo(legajo);
        persona.setNombre("Mock de persona para el legajo " + legajo);
        return persona;
    }

	
	public List<Persona> obtenerPersonas() {
		List<Persona> lista = new ArrayList<Persona>();
        Persona persona1 = new Persona();
        persona1.setLegajo(0L);
        persona1.setNombre("Mock de persona para el legajo " + 0L);
        Persona persona2 = new Persona();
        persona2.setLegajo(1L);
        persona2.setNombre("Mock de persona para el legajo " + 1L);
        lista.add(persona2);
        Persona persona3 = new Persona();
        persona3.setLegajo(2L);
        persona3.setNombre("Mock de persona para el legajo " + 2L);        
        lista.add(persona3);
		return lista;
	}
}
