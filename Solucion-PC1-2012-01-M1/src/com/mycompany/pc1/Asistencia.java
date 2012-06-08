package com.mycompany.pc1;

import java.math.BigDecimal;

public class Asistencia {

	private Periodo periodo;
	private Horario horario;
	private Persona persona;
	private Rol rol;
	private BigDecimal horasDictadas;
	private String fecha;

	public Asistencia(Periodo periodo, Horario horario, String fecha, Persona persona,
			Rol rol, BigDecimal horasDictadas) {
		this.periodo = periodo;
		this.horario = horario;
		this.fecha = fecha;
		this.persona = persona;
		this.rol = rol;
		this.horasDictadas = horasDictadas;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
		
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
		
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
		
	}

	public void setRol(Rol rol) {
		this.rol = rol;
		
	}

	public void setHorasDictadas(BigDecimal horasDictadas) {
		this.horasDictadas = horasDictadas;
		
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public Horario getHorario() {
		return horario;
	}

	public Persona getPersona() {
		return persona;
	}

	public Rol getRol() {
		return rol;
	}

	public BigDecimal getHorasDictadas() {
		return horasDictadas;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
		
	}

	public String getFecha() {
		return fecha;
	}
	
	

}
