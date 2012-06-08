package com.mycompany.pc1;

import java.math.BigDecimal;

public class Rol {

	private String nombre;
	private BigDecimal costoPorHora;
	
	
	public Rol(String nombre, BigDecimal costoPorHora) {
		this.nombre = nombre;
		this.costoPorHora = costoPorHora;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public BigDecimal getCostoPorHora() {
		return costoPorHora;
	}


	public void setCostoPorHora(BigDecimal costoPorHora) {
		this.costoPorHora = costoPorHora;
	}


	
	
}
