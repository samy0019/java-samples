package pe.joedayz.ejemplos.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Represents a credit card entity
 * 
 * @author joedayz
 */
@Entity
@Table(name = "CREDIT_CARD")
public class CreditCard implements Serializable {

	private static final long serialVersionUID = 5924361831551833717L;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;
	
	@Column(name = "TYPE")
	private String type;
	
	@Column(name = "NUMBER")
	private String number;

	@ManyToOne
	private Person person;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	
}
