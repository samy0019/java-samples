package pe.joedayz.ejemplos.service;

import java.util.List;
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
 * Service for processing Credit Cards
 * 
 * @author joedayz
 */
@Service("creditCardService")
@Transactional
public class CreditCardService {

	protected static Logger logger = Logger.getLogger("service");
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	/**
	 * Retrieves all credit cards
	 */
	public List<CreditCard> getAll(Integer personId) {
		logger.debug("Retrieving all credit cards");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM  CreditCard WHERE person.id=" +personId);
		
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Retrieves all credit cards
	 */
	public List<CreditCard> getAll() {
		logger.debug("Retrieving all credit cards");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM  CreditCard");
		
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Retrieves a single credit card
	 */
	public CreditCard get( Integer id ) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing credit card
		CreditCard creditCard = (CreditCard) session.get(CreditCard.class, id);
		
		// Persists to db
		return creditCard;
	}
	
	/**
	 * Adds a new credit card
	 */
	public void add(Integer personId, CreditCard creditCard) {
		logger.debug("Adding new credit card");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing person via id
		Person existingPerson = (Person) session.get(Person.class, personId);
		
		// Add person to credit card
		creditCard.setPerson(existingPerson);
		
		// Persists to db
		session.save(creditCard);
	}
	
	/**
	 * Deletes an existing credit card
	 */
	public void delete(Integer id) {
		logger.debug("Deleting existing credit card");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing credit card
		CreditCard creditCard = (CreditCard) session.get(CreditCard.class, id);
		
		// Delete 
		session.delete(creditCard);
	}
	
	/**
	 * Deletes all credit cards based on the person's id
	 */
	public void deleteAll(Integer personId) {
		logger.debug("Deleting existing credit cards based on person's id");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("DELETE FROM CreditCard WHERE person.id=" +personId);
		
		// Delete all
		query.executeUpdate();
	}
	
	/**
	 * Edits an existing credit card
	 */
	public void edit(CreditCard creditCard) {
		logger.debug("Editing existing creditCard");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing credit card via id
		CreditCard existingCreditCard = (CreditCard) session.get(CreditCard.class, creditCard.getId());
		
		// Assign updated values to this credit card
		existingCreditCard.setNumber(creditCard.getNumber());
		existingCreditCard.setType(creditCard.getType());

		// Save updates
		session.save(existingCreditCard);
	}
}
