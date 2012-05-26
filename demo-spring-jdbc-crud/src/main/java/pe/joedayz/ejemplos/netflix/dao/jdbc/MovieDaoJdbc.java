package pe.joedayz.ejemplos.netflix.dao.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import pe.joedayz.ejemplos.netflix.dao.MovieDao;
import pe.joedayz.ejemplos.netflix.model.Movie;



/**
 * 
 * @author joedayz
 * 
 */
@Repository("mijdbc")
public class MovieDaoJdbc extends SimpleJdbcDaoSupport implements MovieDao {

	private Logger logger = Logger.getLogger(MovieDaoJdbc.class);

	@Autowired
	public MovieDaoJdbc(DataSource dataSource) {
		setDataSource(dataSource);
	}
	

	@Override
	public Movie find(Integer id) {
		Movie movie = null;
		try{
			movie =  getSimpleJdbcTemplate().queryForObject(
					"select id, title, description, director, genre, languages," +
							" starring, duration, year from movies where id=?",
							new BeanPropertyRowMapper<Movie>(Movie.class), id);
		}catch(EmptyResultDataAccessException ex){
			logger.debug("Records not found for id " + id);
		}
		return movie;
	}

	@Override
	public List<Movie> findAll() {
		return getSimpleJdbcTemplate().query(
				"select id, title, description, director, genre, languages," +
				" starring, duration, year from movies",
				new BeanPropertyRowMapper<Movie>(Movie.class));
	}

	@Override
	public void create(Movie movie) {
		getJdbcTemplate().update(
				"insert into movies (title, description, director, genre, languages, " +
				"starring, duration, year) values(?, ?, ?, ?, ?, ?, ?, ?)",
				movie.getTitle(),  movie.getDescription(), movie.getDirector(),
				movie.getGenre(), movie.getLanguages(), movie.getStarring(),
				movie.getDuration(), movie.getYear());
		// Setear el id autogenerado por el identity de HSQL
		movie.setId(getSimpleJdbcTemplate().queryForInt("call identity()"));
		
	}

	@Override
	public void update(Movie movie) {
		getSimpleJdbcTemplate().update(
				"update movies set title=?, description=?, director=?," +
				" genre=?, languages=?, starring=?, duration=?, year=? where id=?",
				movie.getTitle(), movie.getDescription(), 
				movie.getDirector(), movie.getGenre(), 
				movie.getLanguages(), movie.getStarring(),
				movie.getDuration(), movie.getYear(), movie.getId());
		
	}

	@Override
	public void delete(Integer id) {
		getSimpleJdbcTemplate().update("delete from movies where id=?", id);
	}

}
