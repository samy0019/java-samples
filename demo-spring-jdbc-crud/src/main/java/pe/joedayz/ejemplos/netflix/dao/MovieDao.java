package pe.joedayz.ejemplos.netflix.dao;

import java.util.List;

import pe.joedayz.ejemplos.netflix.model.Movie;

/**
 * 
 * @author: joedayz
 * 
 */

public interface MovieDao {

	

	Movie find(Integer id);

	List<Movie> findAll();

	void create(Movie movie);

	void update(Movie movie);

	void delete(Integer id);

}
