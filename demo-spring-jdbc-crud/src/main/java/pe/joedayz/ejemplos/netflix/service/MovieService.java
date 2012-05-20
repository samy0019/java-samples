package pe.joedayz.ejemplos.netflix.service;

import java.util.List;

import pe.joedayz.ejemplos.netflix.model.Movie;

/**
 * 
 * @author josediaz
 *
 */

public interface MovieService {

	Movie find(Integer id);

	List<Movie> findAll();

	void create(Movie book);

	void update(Movie book);

	void delete(Integer id);
}
