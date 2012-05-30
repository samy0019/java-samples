package pe.joedayz.ejemplos.cxf;

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
}
