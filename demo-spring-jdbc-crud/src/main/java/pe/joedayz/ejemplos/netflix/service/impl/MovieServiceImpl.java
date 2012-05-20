package pe.joedayz.ejemplos.netflix.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.joedayz.ejemplos.netflix.dao.MovieDao;
import pe.joedayz.ejemplos.netflix.model.Movie;
import pe.joedayz.ejemplos.netflix.service.MovieService;

/**
 * 
 * @author josediaz
 *
 */


@Service
@Transactional
public class MovieServiceImpl implements MovieService {

	private Logger logger = Logger.getLogger(MovieServiceImpl.class);
	@Autowired
	private MovieDao movieDao;	
	
	@Override
	public Movie find(Integer id) {
		return movieDao.find(id);
	}

	@Override
	public List<Movie> findAll() {
		return movieDao.findAll();
	}

	@Override
	public void create(Movie movie) {
		movieDao.create(movie);
		logger.debug("Movie created with id: " + movie.getId());

	}

	@Override
	public void update(Movie movie) {
		movieDao.update(movie);

	}

	@Override
	public void delete(Integer id) {
		movieDao.delete(id);

	}

}
