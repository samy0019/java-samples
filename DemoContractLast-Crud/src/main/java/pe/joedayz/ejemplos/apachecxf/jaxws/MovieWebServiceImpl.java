package pe.joedayz.ejemplos.apachecxf.jaxws;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import pe.joedayz.ejemplos.netflix.model.Movie;
import pe.joedayz.ejemplos.netflix.service.MovieService;


/**
 * Implementaci—n del Web Service, hace uso del BookService.
 * 
 * @author joedayz
 * 
 */
@WebService(endpointInterface = "pe.joedayz.ejemplos.apachecxf.jaxws.MovieWebService")
public class MovieWebServiceImpl implements MovieWebService {
	/**
	 * Bean configurado por Spring, est‡ en el proyecto demo-spring-jdbc-crud
	 * configurado en el pom.xml
	 */
	@Autowired
	private MovieService movieService;

	@Override
	public Movie find(Integer id) {
		return movieService.find(id);
	}

	@Override
	public List<Movie> findAll() {
		return movieService.findAll();
	}

	@Override
	public void create(Movie movie) {
		movieService.create(movie);
	}

	@Override
	public void update(Movie movie) {
		movieService.update(movie);
	}

	@Override
	public void delete(Integer id) {
		movieService.delete(id);
	}

}
