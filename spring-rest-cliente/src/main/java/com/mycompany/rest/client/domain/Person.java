package com.mycompany.rest.client.domain;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="person")
public class Person {

	
	private Long id;
	private String firstName;
	private String lastName;
	private Double money;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	
	
}
