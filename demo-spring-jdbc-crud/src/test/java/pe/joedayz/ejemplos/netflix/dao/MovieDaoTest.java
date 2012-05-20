package pe.joedayz.ejemplos.netflix.dao;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import pe.joedayz.ejemplos.netflix.model.Movie;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext-test.xml")
@Transactional
public class MovieDaoTest {

	
	private Logger logger = Logger.getLogger(MovieDaoTest.class);

	@Autowired
	private MovieDao movieDao;

	@Test
	public void testFind() {
		Assert.assertEquals("August Rush", movieDao.find(0)
				.getTitle());
	}

	
	@Test
	public void testCrud() {
		Movie create = new Movie();
		create.setTitle("New title");
		create.setDescription("New description");
		movieDao.create(create);
		Assert.assertEquals("New title", movieDao.find(create.getId())
				.getTitle());
		logger.debug("Movie creado, con id=" + create.getId());

		Movie update = movieDao.find(create.getId());
		update.setTitle("Updated title");
		movieDao.update(update);
		Assert.assertEquals("Updated title", movieDao.find(create.getId())
				.getTitle());

		movieDao.delete(create.getId());

		Assert.assertNull(movieDao.find(create.getId()));
	}	
}
