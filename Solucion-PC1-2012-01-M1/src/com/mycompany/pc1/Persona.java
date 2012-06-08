package com.mycompany.pc1;

import java.util.List;


public class Persona {

	private String nombre;
	private String dni;
	private String email;
	private String ciu;
	private List<Rol> roles;

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDni(String dni) {
		this.dni = dni;
		
	}

	public void setEmail(String email) {
		this.email = email;
		
	}

	public void setCiu(String ciu) {
		this.ciu = ciu;
		
	}

	public String getNombre() {
		return nombre;
	}

	public String getDni() {
		return dni;
	}

	public String getEmail() {
		return email;
	}

	public String getCiu() {
		return ciu;
	}


	public void setRoles(List<Rol> roles) {
		this.roles = roles;
		
	}

	public List<Rol> getRoles() {
		return roles;
	}
	
	
	


}
