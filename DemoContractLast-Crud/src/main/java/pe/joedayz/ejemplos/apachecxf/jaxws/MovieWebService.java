package pe.joedayz.ejemplos.apachecxf.jaxws;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import pe.joedayz.ejemplos.netflix.model.Movie;


/**
 * Web Service SOAP, expone métodos CRUD.
 * 
 * @author joedayz
 * 
 */
@WebService
public interface MovieWebService {

	

	Movie find(@WebParam(name = "id") Integer id);

	List<Movie> findAll();

	void create(@WebParam(name = "movie") Movie movie);

	void update(@WebParam(name = "movie") Movie movie);

	void delete(@WebParam(name = "id") Integer id);
}
