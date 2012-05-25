package pe.joedayz.ejemplos.apachecxf.jaxws;



import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Test de integraci—n del Web Service.
 * 
 * @author joedayz
 */
@ContextConfiguration("/applicationContext-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MovieWebServiceIntegrationTest {

	@Autowired
	private MovieWebService movieWebService;

	@Test
	public void testFind() {
		Assert.assertEquals("August Rush", movieWebService
				.find(0).getTitle());
	}
	
	@Test
	public void testFind2() {
		Assert.assertEquals("August Rush", movieWebService
				.find(99).getTitle());
	}
}
