package pe.joedayz.ejemplos.dto;

import java.util.List;

import pe.joedayz.ejemplos.domain.CreditCard;

/**
 * Data Transfer Object for displaying purposes
 * 
 * @author joedayz
 */
public class PersonDTO {

	private Integer id;
	private String firstName;
	private String lastName;
	private Double money;
	private List<CreditCard> creditCards;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public List<CreditCard> getCreditCards() {
		return creditCards;
	}
	public void setCreditCards(List<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}
}
