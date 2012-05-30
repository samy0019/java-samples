package pe.joedayz.ejemplos.cxf;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;


/** La interfaz del servicio web se anota con @WebService y el resto de las
 * anotaciones estandar de JWS. Con esta unica anotacion es suficiente para
 * tener un web service funcionando con Apache CXF.
 */
@WebService
public interface HolaMundo {

	
	  /** Cada método sera una operación del web service. Puede ser tan simple
     * como este ejemplo, sin niguna anotación extra. En este caso, el nombre
     * del parámetro y del mensaje de resultado serán generados por defecto.
     */
    String decirHola(String nombre);

    /** Los métodos pueden también devolver objetos complejos. Además, es
     * posible utilizar las anotaciones @WebResult y @WebParam para darle
     * nombres específicos a los mensajes del web service.
     */
    @WebResult(name="persona")
    Persona buscarPersona(@WebParam(name="legajo") long legajo);
}
