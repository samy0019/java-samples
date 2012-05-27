package pe.joedayz.ejemplos.service;

import java.util.ArrayList;
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
		Query query = session.createQuery("FROM Person as p LEFT JOIN FETCH  p.creditCards WHERE p.id="+personId);
		
		Person person = (Person) query.uniqueResult();
		
		// Retrieve all
		return  new ArrayList<CreditCard>(person.getCreditCards());
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
	
		// Persists to db
		session.save(creditCard);
		
		// Add to person as well
		// Retrieve existing person via id
		Person existingPerson = (Person) session.get(Person.class, personId);
		
		// Assign updated values to this person
		existingPerson.getCreditCards().add(creditCard);

		// Save updates
		session.save(existingPerson);
	}
	
	/**
	 * Deletes an existing credit card
	 */
	public void delete(Integer id) {
		logger.debug("Deleting existing credit card");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
    	// Delete reference to foreign key credit card first
		// We need a SQL query instead of HQL query here to access the third table
    	Query query = session.createSQLQuery("DELETE FROM PERSON_CREDIT_CARD " +
    			"WHERE creditCards_ID="+id);
    	
    	query.executeUpdate();
    	
		// Retrieve existing credit card
		CreditCard creditCard = (CreditCard) session.get(CreditCard.class, id);
		
		// Delete 
		session.delete(creditCard);
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
