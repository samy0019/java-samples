package pe.joedayz.ejemplos.service;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.joedayz.ejemplos.domain.CreditCard;
import pe.joedayz.ejemplos.domain.Person;

/**
 * Service for processing Persons
 * 
 * @author joedayz
 */
@Service("personService")
@Transactional
public class PersonService {

	protected static Logger logger = Logger.getLogger("service");
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	/**
	 * Retrieves all persons
	 * 
	 * @return a list of persons
	 */
	public List<Person> getAll() {
		logger.debug("Retrieving all persons");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();

		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM Person");
		
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Retrieves a single person
	 */
	public Person get( Integer id ) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing person
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM Person as p LEFT JOIN FETCH  p.creditCards WHERE p.id="+id);
		
		return (Person) query.uniqueResult();
	}
	
	/**
	 * Adds a new person
	 */
	public void add(Person person) {
		logger.debug("Adding new person");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Persists to db
		session.save(person);
	}
	
	/**
	 * Deletes an existing person
	 * @param id the id of the existing person
	 */
	public void delete(Integer id) {
		logger.debug("Deleting existing person");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM Person as p LEFT JOIN FETCH  p.creditCards WHERE p.id="+id);
	
		// Retrieve record
		Person person = (Person) query.uniqueResult();
		
		Set<CreditCard> creditCards =person.getCreditCards();
		
		// Delete person
		session.delete(person);
		
		// Delete associated credit cards
		for (CreditCard creditCard: creditCards) {
			session.delete(creditCard);
		}
	}
	
	/**
	 * Edits an existing person
	 */
	public void edit(Person person) {
		logger.debug("Editing existing person");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing person via id
		Person existingPerson = (Person) session.get(Person.class, person.getId());
		
		// Assign updated values to this person
		existingPerson.setFirstName(person.getFirstName());
		existingPerson.setLastName(person.getLastName());
		existingPerson.setMoney(person.getMoney());

		// Save updates
		session.save(existingPerson);
	}
}
